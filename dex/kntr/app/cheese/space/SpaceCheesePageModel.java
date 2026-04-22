package kntr.app.cheese.space;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.material3.pulltorefresh.PullToRefreshDefaults;
import androidx.compose.material3.pulltorefresh.PullToRefreshKt;
import androidx.compose.material3.pulltorefresh.PullToRefreshState;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.ogv.bdesign.placeholder.LoadFailurePlaceholderKt;
import com.bilibili.ogv.bdesign.placeholder.NetworkErrorPlaceholderKt;
import com.bilibili.ogv.bpf.neuron.NeuronTrackTechKt;
import javax.inject.Inject;
import kntr.app.cheese.space.PageState;
import kntr.app.cheese.space.aggregate.UpId;
import kntr.app.cheese.space.api.SpaceCheesePageApi;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.komponent.HostConfiguration;
import kntr.common.komponent.Komponent;
import kntr.common.komponent.KomponentHostScope;
import kntr.common.komponent.KomponentKt;
import kntr.common.komponent.KomponentScope;
import kntr.common.komponent.SetContentResult;
import kntr.common.komponent.UiComposableLike;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: SpaceCheesePageModel.kt */
@PageScope
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\b\u0007\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r²\u0006\n\u0010\u000e\u001a\u00020\u000fX\u008a\u008e\u0002²\u0006\u0010\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u008a\u0084\u0002"}, d2 = {"Lkntr/app/cheese/space/SpaceCheesePageModel;", RoomRecommendViewModel.EMPTY_CURSOR, "pgcPageChannelApi", "Lkntr/app/cheese/space/api/SpaceCheesePageApi;", "createPerLoadKomponent", "Lkntr/app/cheese/space/CreatePerLoadKomponent;", "upId", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Lkntr/app/cheese/space/api/SpaceCheesePageApi;Lkntr/app/cheese/space/CreatePerLoadKomponent;J)V", "komponent", "Lkntr/common/komponent/Komponent;", "Lkntr/app/cheese/space/SpaceCheesePageState;", "space_debug", "uiState", "Lkntr/app/cheese/space/PageState;", "content", "Lkntr/common/komponent/UiComposableLike;", RoomRecommendViewModel.EMPTY_CURSOR}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SpaceCheesePageModel {
    public static final int $stable = 8;
    private final CreatePerLoadKomponent createPerLoadKomponent;
    private final SpaceCheesePageApi pgcPageChannelApi;
    private final long upId;

    @Inject
    public SpaceCheesePageModel(SpaceCheesePageApi pgcPageChannelApi, CreatePerLoadKomponent createPerLoadKomponent, @UpId long upId) {
        Intrinsics.checkNotNullParameter(pgcPageChannelApi, "pgcPageChannelApi");
        Intrinsics.checkNotNullParameter(createPerLoadKomponent, "createPerLoadKomponent");
        this.pgcPageChannelApi = pgcPageChannelApi;
        this.createPerLoadKomponent = createPerLoadKomponent;
        this.upId = upId;
    }

    public final Komponent<SpaceCheesePageState> komponent() {
        return KomponentKt.Komponent(new Function1() { // from class: kntr.app.cheese.space.SpaceCheesePageModel$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                SetContentResult komponent$lambda$0;
                komponent$lambda$0 = SpaceCheesePageModel.komponent$lambda$0(SpaceCheesePageModel.this, (KomponentScope) obj);
                return komponent$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SetContentResult komponent$lambda$0(final SpaceCheesePageModel this$0, final KomponentScope $this$Komponent) {
        Intrinsics.checkNotNullParameter($this$Komponent, "$this$Komponent");
        final MutableState uiState$delegate = SnapshotStateKt.mutableStateOf$default(PageState.Loading.INSTANCE, (SnapshotMutationPolicy) null, 2, (Object) null);
        komponent$lambda$0$refreshData($this$Komponent, this$0, uiState$delegate);
        NeuronTrackTechKt.getNeuronTrackTech().invoke("pugv.space.cheese.kntr.pageview", MapsKt.emptyMap());
        final Flow $this$map$iv = SnapshotStateKt.snapshotFlow(new Function0() { // from class: kntr.app.cheese.space.SpaceCheesePageModel$$ExternalSyntheticLambda0
            public final Object invoke() {
                PageState komponent$lambda$0$0;
                komponent$lambda$0$0 = SpaceCheesePageModel.komponent$lambda$0$0(uiState$delegate);
                return komponent$lambda$0$0;
            }
        });
        Flow it = new Flow<Komponent<? extends Unit>>() { // from class: kntr.app.cheese.space.SpaceCheesePageModel$komponent$lambda$0$$inlined$map$1

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
            /* renamed from: kntr.app.cheese.space.SpaceCheesePageModel$komponent$lambda$0$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ KomponentScope $this_Komponent$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ MutableState $uiState$delegate$inlined;
                final /* synthetic */ SpaceCheesePageModel this$0;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "kntr.app.cheese.space.SpaceCheesePageModel$komponent$lambda$0$$inlined$map$1$2", f = "SpaceCheesePageModel.kt", i = {0, 0, 0, 0, 0}, l = {219}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                /* renamed from: kntr.app.cheese.space.SpaceCheesePageModel$komponent$lambda$0$$inlined$map$1$2$1  reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector, SpaceCheesePageModel spaceCheesePageModel, KomponentScope komponentScope, MutableState mutableState) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = spaceCheesePageModel;
                    this.$this_Komponent$inlined = komponentScope;
                    this.$uiState$delegate$inlined = mutableState;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
                /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
                /* JADX WARN: Removed duplicated region for block: B:13:0x0043  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object value, Continuation $completion) {
                    Continuation $continuation;
                    CreatePerLoadKomponent createPerLoadKomponent;
                    Komponent<Unit> invoke;
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
                                    final PageState it = (PageState) value;
                                    if (it instanceof PageState.Failure) {
                                        final KomponentScope komponentScope = this.$this_Komponent$inlined;
                                        final MutableState mutableState = this.$uiState$delegate$inlined;
                                        final SpaceCheesePageModel spaceCheesePageModel = this.this$0;
                                        invoke = KomponentKt.Komponent(
                                        /*  JADX ERROR: Method code generation error
                                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0065: INVOKE  (r12v13 'invoke' kntr.common.komponent.Komponent<kotlin.Unit>) = 
                                              (wrap: kotlin.jvm.functions.Function1<kntr.common.komponent.KomponentScope<? super kotlin.Unit>, kntr.common.komponent.SetContentResult> : 0x0060: CONSTRUCTOR  (r12v11 kotlin.jvm.functions.Function1<kntr.common.komponent.KomponentScope<? super kotlin.Unit>, kntr.common.komponent.SetContentResult> A[REMOVE]) = 
                                              (r10v1 'it' kntr.app.cheese.space.PageState A[D('it' kntr.app.cheese.space.PageState), DONT_INLINE])
                                              (r13v3 'komponentScope' kntr.common.komponent.KomponentScope A[DONT_INLINE])
                                              (r14v0 'mutableState' androidx.compose.runtime.MutableState A[DONT_INLINE])
                                              (r15v0 'spaceCheesePageModel' kntr.app.cheese.space.SpaceCheesePageModel A[DONT_INLINE])
                                             call: kntr.app.cheese.space.SpaceCheesePageModel$komponent$1$content$3$1.<init>(kntr.app.cheese.space.PageState, kntr.common.komponent.KomponentScope, androidx.compose.runtime.MutableState, kntr.app.cheese.space.SpaceCheesePageModel):void type: CONSTRUCTOR)
                                             type: STATIC call: kntr.common.komponent.KomponentKt.Komponent(kotlin.jvm.functions.Function1):kntr.common.komponent.Komponent in method: kntr.app.cheese.space.SpaceCheesePageModel$komponent$lambda$0$$inlined$map$1.2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object, file: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:309)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:272)
                                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
                                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:123)
                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
                                            	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:267)
                                            	at jadx.core.dex.regions.SwitchRegion.generate(SwitchRegion.java:79)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:123)
                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:123)
                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:296)
                                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:275)
                                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:377)
                                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:306)
                                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:272)
                                            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                                            	at java.util.ArrayList.forEach(ArrayList.java:1257)
                                            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:390)
                                            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: kntr.app.cheese.space.SpaceCheesePageModel$komponent$1$content$3$1, state: NOT_LOADED
                                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:302)
                                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:769)
                                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:718)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:417)
                                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:144)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1097)
                                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:872)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:421)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:302)
                                            	... 39 more
                                            */
                                        /*
                                            this = this;
                                            r0 = r16
                                            r1 = r18
                                            boolean r2 = r1 instanceof kntr.app.cheese.space.SpaceCheesePageModel$komponent$lambda$0$$inlined$map$1.AnonymousClass2.AnonymousClass1
                                            if (r2 == 0) goto L18
                                            r2 = r1
                                            kntr.app.cheese.space.SpaceCheesePageModel$komponent$lambda$0$$inlined$map$1$2$1 r2 = (kntr.app.cheese.space.SpaceCheesePageModel$komponent$lambda$0$$inlined$map$1.AnonymousClass2.AnonymousClass1) r2
                                            int r3 = r2.label
                                            r4 = -2147483648(0xffffffff80000000, float:-0.0)
                                            r3 = r3 & r4
                                            if (r3 == 0) goto L18
                                            int r3 = r2.label
                                            int r3 = r3 - r4
                                            r2.label = r3
                                            goto L1d
                                        L18:
                                            kntr.app.cheese.space.SpaceCheesePageModel$komponent$lambda$0$$inlined$map$1$2$1 r2 = new kntr.app.cheese.space.SpaceCheesePageModel$komponent$lambda$0$$inlined$map$1$2$1
                                            r2.<init>(r1)
                                        L1d:
                                            java.lang.Object r3 = r2.result
                                            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                            int r5 = r2.label
                                            switch(r5) {
                                                case 0: goto L43;
                                                case 1: goto L30;
                                                default: goto L28;
                                            }
                                        L28:
                                            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
                                            java.lang.String r3 = "call to 'resume' before 'invoke' with coroutine"
                                            r2.<init>(r3)
                                            throw r2
                                        L30:
                                            int r4 = r2.I$0
                                            java.lang.Object r5 = r2.L$3
                                            kotlinx.coroutines.flow.FlowCollector r5 = (kotlinx.coroutines.flow.FlowCollector) r5
                                            java.lang.Object r6 = r2.L$2
                                            java.lang.Object r7 = r2.L$1
                                            kntr.app.cheese.space.SpaceCheesePageModel$komponent$lambda$0$$inlined$map$1$2$1 r7 = (kntr.app.cheese.space.SpaceCheesePageModel$komponent$lambda$0$$inlined$map$1.AnonymousClass2.AnonymousClass1) r7
                                            java.lang.Object r8 = r2.L$0
                                            kotlin.ResultKt.throwOnFailure(r3)
                                            goto Lb8
                                        L43:
                                            kotlin.ResultKt.throwOnFailure(r3)
                                            kotlinx.coroutines.flow.FlowCollector r5 = r0.$this_unsafeFlow
                                            r7 = r2
                                            r6 = r17
                                            r8 = 0
                                            r9 = r2
                                            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
                                            r10 = r6
                                            kntr.app.cheese.space.PageState r10 = (kntr.app.cheese.space.PageState) r10
                                            r11 = 0
                                            boolean r12 = r10 instanceof kntr.app.cheese.space.PageState.Failure
                                            if (r12 == 0) goto L6a
                                            kntr.app.cheese.space.SpaceCheesePageModel$komponent$1$content$3$1 r12 = new kntr.app.cheese.space.SpaceCheesePageModel$komponent$1$content$3$1
                                            kntr.common.komponent.KomponentScope r13 = r0.$this_Komponent$inlined
                                            androidx.compose.runtime.MutableState r14 = r0.$uiState$delegate$inlined
                                            kntr.app.cheese.space.SpaceCheesePageModel r15 = r0.this$0
                                            r12.<init>(r10, r13, r14, r15)
                                            kotlin.jvm.functions.Function1 r12 = (kotlin.jvm.functions.Function1) r12
                                            kntr.common.komponent.Komponent r12 = kntr.common.komponent.KomponentKt.Komponent(r12)
                                            goto L90
                                        L6a:
                                            kntr.app.cheese.space.PageState$Loading r12 = kntr.app.cheese.space.PageState.Loading.INSTANCE
                                            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual(r10, r12)
                                            if (r12 == 0) goto L7b
                                            kntr.app.cheese.space.SpaceCheesePageModel$komponent$1$content$3$2 r12 = kntr.app.cheese.space.SpaceCheesePageModel$komponent$1$content$3$2.INSTANCE
                                            kotlin.jvm.functions.Function1 r12 = (kotlin.jvm.functions.Function1) r12
                                            kntr.common.komponent.Komponent r12 = kntr.common.komponent.KomponentKt.Komponent(r12)
                                            goto L90
                                        L7b:
                                            boolean r12 = r10 instanceof kntr.app.cheese.space.PageState.Ready
                                            if (r12 == 0) goto Lbb
                                            kntr.app.cheese.space.SpaceCheesePageModel r12 = r0.this$0
                                            kntr.app.cheese.space.CreatePerLoadKomponent r12 = kntr.app.cheese.space.SpaceCheesePageModel.access$getCreatePerLoadKomponent$p(r12)
                                            r13 = r10
                                            kntr.app.cheese.space.PageState$Ready r13 = (kntr.app.cheese.space.PageState.Ready) r13
                                            kntr.app.cheese.space.api.PageData r13 = r13.getPageData()
                                            kntr.common.komponent.Komponent r12 = r12.invoke(r13)
                                        L90:
                                            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r17)
                                            r2.L$0 = r9
                                            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
                                            r2.L$1 = r9
                                            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
                                            r2.L$2 = r9
                                            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
                                            r2.L$3 = r9
                                            r2.I$0 = r8
                                            r9 = 1
                                            r2.label = r9
                                            java.lang.Object r9 = r5.emit(r12, r2)
                                            if (r9 != r4) goto Lb5
                                            return r4
                                        Lb5:
                                            r4 = r8
                                            r8 = r17
                                        Lb8:
                                            kotlin.Unit r4 = kotlin.Unit.INSTANCE
                                            return r4
                                        Lbb:
                                            kotlin.NoWhenBranchMatchedException r4 = new kotlin.NoWhenBranchMatchedException
                                            r4.<init>()
                                            throw r4
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: kntr.app.cheese.space.SpaceCheesePageModel$komponent$lambda$0$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                                    }
                                }

                                public Object collect(FlowCollector collector, Continuation $completion) {
                                    Object collect = $this$map$iv.collect(new AnonymousClass2(collector, this$0, $this$Komponent, uiState$delegate), $completion);
                                    return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                                }
                            };
                            final State content$delegate = KomponentKt.embedFlow((KomponentHostScope) $this$Komponent, it);
                            final Object state$iv = new SpaceCheesePageState() { // from class: kntr.app.cheese.space.SpaceCheesePageModel$komponent$1$1
                                @Override // kntr.app.cheese.space.SpaceCheesePageState
                                public void onRefresh() {
                                    SpaceCheesePageModel.komponent$lambda$0$refreshData($this$Komponent, this$0, uiState$delegate);
                                }
                            };
                            UiComposableLike content$iv$iv = new UiComposableLike<SpaceCheesePageModel$komponent$1$1>(state$iv, $this$Komponent, uiState$delegate, content$delegate) { // from class: kntr.app.cheese.space.SpaceCheesePageModel$komponent$lambda$0$$inlined$setContent$1
                                final /* synthetic */ State $content$delegate$inlined;
                                final /* synthetic */ KomponentScope $this_setContent;
                                final /* synthetic */ MutableState $uiState$delegate$inlined;
                                private final SpaceCheesePageModel$komponent$1$1 state;

                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    this.$this_setContent = $this$Komponent;
                                    this.$uiState$delegate$inlined = uiState$delegate;
                                    this.$content$delegate$inlined = content$delegate;
                                    this.state = state$iv;
                                }

                                /* JADX WARN: Removed duplicated region for block: B:22:0x0084  */
                                /* JADX WARN: Removed duplicated region for block: B:26:0x011c  */
                                /* JADX WARN: Removed duplicated region for block: B:29:0x0128  */
                                /* JADX WARN: Removed duplicated region for block: B:30:0x012e  */
                                /* JADX WARN: Removed duplicated region for block: B:33:0x0248  */
                                /* JADX WARN: Removed duplicated region for block: B:36:0x0254  */
                                /* JADX WARN: Removed duplicated region for block: B:37:0x025a  */
                                /* JADX WARN: Removed duplicated region for block: B:40:0x0358  */
                                /*
                                    Code decompiled incorrectly, please refer to instructions dump.
                                */
                                public void invoke(Modifier modifier, Composer $composer, int $changed) {
                                    PageState komponent$lambda$0$0;
                                    boolean refreshing;
                                    Object it$iv;
                                    Function0 factory$iv$iv$iv;
                                    Function0 factory$iv$iv$iv2;
                                    UiComposableLike komponent$lambda$0$7;
                                    PageState komponent$lambda$0$02;
                                    Intrinsics.checkNotNullParameter(modifier, "modifier");
                                    $composer.startReplaceGroup(1906618612);
                                    ComposerKt.sourceInformation($composer, "C(invoke)N(modifier)87@2987L17:Komponent.kt#vxw63z");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1906618612, $changed, -1, "kntr.common.komponent.setContent.<no name provided>.invoke (Komponent.kt:86)");
                                    }
                                    int i = $changed & 14;
                                    $composer.startReplaceGroup(892287252);
                                    ComposerKt.sourceInformation($composer, "CN(modifier)*124@4892L28,130@5144L2,126@4942L905:SpaceCheesePageModel.kt#mv22nr");
                                    komponent$lambda$0$0 = SpaceCheesePageModel.komponent$lambda$0$0(this.$uiState$delegate$inlined);
                                    if (!(komponent$lambda$0$0 instanceof PageState.Loading)) {
                                        komponent$lambda$0$02 = SpaceCheesePageModel.komponent$lambda$0$0(this.$uiState$delegate$inlined);
                                        PageState.Ready ready = komponent$lambda$0$02 instanceof PageState.Ready ? (PageState.Ready) komponent$lambda$0$02 : null;
                                        if (!(ready != null && ready.getRefreshing())) {
                                            refreshing = false;
                                            PullToRefreshState pullRefreshState = PullToRefreshKt.rememberPullToRefreshState($composer, 0);
                                            ComposerKt.sourceInformationMarkerStart($composer, -663940014, "CC(remember):SpaceCheesePageModel.kt#9igjgp");
                                            it$iv = $composer.rememberedValue();
                                            if (it$iv == Composer.Companion.getEmpty()) {
                                                Object value$iv = (Function0) new Function0<Unit>() { // from class: kntr.app.cheese.space.SpaceCheesePageModel$komponent$1$2$1$1
                                                    public /* bridge */ /* synthetic */ Object invoke() {
                                                        m544invoke();
                                                        return Unit.INSTANCE;
                                                    }

                                                    /* renamed from: invoke  reason: collision with other method in class */
                                                    public final void m544invoke() {
                                                    }
                                                };
                                                $composer.updateRememberedValue(value$iv);
                                                it$iv = value$iv;
                                            }
                                            ComposerKt.sourceInformationMarkerEnd($composer);
                                            Modifier modifier$iv = PullToRefreshKt.pullToRefresh-Z4HSEVQ$default(modifier, refreshing, pullRefreshState, false, 0.0f, (Function0) it$iv, 8, (Object) null);
                                            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                                            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                                            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                                            int $changed$iv$iv = (48 << 3) & 112;
                                            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                                            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                                            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
                                            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
                                            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
                                            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                                            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                                            if (!($composer.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            $composer.startReusableNode();
                                            if (!$composer.getInserting()) {
                                                factory$iv$iv$iv = factory$iv$iv$iv3;
                                                $composer.createNode(factory$iv$iv$iv);
                                            } else {
                                                factory$iv$iv$iv = factory$iv$iv$iv3;
                                                $composer.useNode();
                                            }
                                            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer);
                                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                                            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                                            int i2 = ($changed$iv$iv$iv >> 6) & 14;
                                            ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                                            int i3 = ((48 >> 6) & 112) | 6;
                                            BoxScope $this$komponent_u24lambda_u240_u248_u241 = BoxScopeInstance.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart($composer, 23373067, "C135@5368L6,135@5331L161,142@5781L6,138@5539L286:SpaceCheesePageModel.kt#mv22nr");
                                            Modifier modifier$iv2 = BackgroundKt.background-bw27NRU$default(modifier, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null);
                                            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                                            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                                            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
                                            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                            int $changed$iv$iv2 = (0 << 3) & 112;
                                            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                                            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                                            CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
                                            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
                                            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
                                            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                                            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                                            if (!($composer.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            $composer.startReusableNode();
                                            if (!$composer.getInserting()) {
                                                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                                                $composer.createNode(factory$iv$iv$iv2);
                                            } else {
                                                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                                                $composer.useNode();
                                            }
                                            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer);
                                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                                            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                                            int i4 = ($changed$iv$iv$iv2 >> 6) & 14;
                                            ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                                            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                                            int i5 = ((0 >> 6) & 112) | 6;
                                            ComposerKt.sourceInformationMarkerStart($composer, 431039448, "C136@5411L55:SpaceCheesePageModel.kt#mv22nr");
                                            komponent$lambda$0$7 = SpaceCheesePageModel.komponent$lambda$0$7(this.$content$delegate$inlined);
                                            komponent$lambda$0$7.invoke(WindowInsetsPadding_androidKt.navigationBarsPadding(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null)), $composer, 0);
                                            ComposerKt.sourceInformationMarkerEnd($composer);
                                            ComposerKt.sourceInformationMarkerEnd($composer);
                                            $composer.endNode();
                                            ComposerKt.sourceInformationMarkerEnd($composer);
                                            ComposerKt.sourceInformationMarkerEnd($composer);
                                            ComposerKt.sourceInformationMarkerEnd($composer);
                                            PullToRefreshDefaults.INSTANCE.Indicator-2poqoh4(pullRefreshState, refreshing, $this$komponent_u24lambda_u240_u248_u241.align(Modifier.Companion, Alignment.Companion.getTopCenter()), 0L, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBrand_pink-0d7_KjU(), 0.0f, $composer, PullToRefreshDefaults.$stable << 18, 40);
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
                                    }
                                    refreshing = true;
                                    PullToRefreshState pullRefreshState2 = PullToRefreshKt.rememberPullToRefreshState($composer, 0);
                                    ComposerKt.sourceInformationMarkerStart($composer, -663940014, "CC(remember):SpaceCheesePageModel.kt#9igjgp");
                                    it$iv = $composer.rememberedValue();
                                    if (it$iv == Composer.Companion.getEmpty()) {
                                    }
                                    ComposerKt.sourceInformationMarkerEnd($composer);
                                    Modifier modifier$iv3 = PullToRefreshKt.pullToRefresh-Z4HSEVQ$default(modifier, refreshing, pullRefreshState2, false, 0.0f, (Function0) it$iv, 8, (Object) null);
                                    Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
                                    ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                                    MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                                    int $changed$iv$iv3 = (48 << 3) & 112;
                                    ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                                    int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                                    CompositionLocalMap localMap$iv$iv3 = $composer.getCurrentCompositionLocalMap();
                                    Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer, modifier$iv3);
                                    Function0 factory$iv$iv$iv32 = ComposeUiNode.Companion.getConstructor();
                                    int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                                    ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                                    if (!($composer.getApplier() instanceof Applier)) {
                                    }
                                    $composer.startReusableNode();
                                    if (!$composer.getInserting()) {
                                    }
                                    Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer);
                                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                                    int i22 = ($changed$iv$iv$iv3 >> 6) & 14;
                                    ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                                    int i32 = ((48 >> 6) & 112) | 6;
                                    BoxScope $this$komponent_u24lambda_u240_u248_u2412 = BoxScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart($composer, 23373067, "C135@5368L6,135@5331L161,142@5781L6,138@5539L286:SpaceCheesePageModel.kt#mv22nr");
                                    Modifier modifier$iv22 = BackgroundKt.background-bw27NRU$default(modifier, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null);
                                    ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                                    Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
                                    Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getStart();
                                    MeasurePolicy measurePolicy$iv22 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                    int $changed$iv$iv22 = (0 << 3) & 112;
                                    ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                                    int compositeKeyHash$iv$iv22 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                                    CompositionLocalMap localMap$iv$iv22 = $composer.getCurrentCompositionLocalMap();
                                    Modifier materialized$iv$iv22 = ComposedModifierKt.materializeModifier($composer, modifier$iv22);
                                    Function0 factory$iv$iv$iv42 = ComposeUiNode.Companion.getConstructor();
                                    int $changed$iv$iv$iv22 = (($changed$iv$iv22 << 6) & 896) | 6;
                                    ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                                    if (!($composer.getApplier() instanceof Applier)) {
                                    }
                                    $composer.startReusableNode();
                                    if (!$composer.getInserting()) {
                                    }
                                    Composer $this$Layout_u24lambda_u240$iv$iv22 = Updater.constructor-impl($composer);
                                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, measurePolicy$iv22, ComposeUiNode.Companion.getSetMeasurePolicy());
                                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, localMap$iv$iv22, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv22, Integer.valueOf(compositeKeyHash$iv$iv22), ComposeUiNode.Companion.getSetCompositeKeyHash());
                                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv22, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, materialized$iv$iv22, ComposeUiNode.Companion.getSetModifier());
                                    int i42 = ($changed$iv$iv$iv22 >> 6) & 14;
                                    ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                                    ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
                                    int i52 = ((0 >> 6) & 112) | 6;
                                    ComposerKt.sourceInformationMarkerStart($composer, 431039448, "C136@5411L55:SpaceCheesePageModel.kt#mv22nr");
                                    komponent$lambda$0$7 = SpaceCheesePageModel.komponent$lambda$0$7(this.$content$delegate$inlined);
                                    komponent$lambda$0$7.invoke(WindowInsetsPadding_androidKt.navigationBarsPadding(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null)), $composer, 0);
                                    ComposerKt.sourceInformationMarkerEnd($composer);
                                    ComposerKt.sourceInformationMarkerEnd($composer);
                                    $composer.endNode();
                                    ComposerKt.sourceInformationMarkerEnd($composer);
                                    ComposerKt.sourceInformationMarkerEnd($composer);
                                    ComposerKt.sourceInformationMarkerEnd($composer);
                                    PullToRefreshDefaults.INSTANCE.Indicator-2poqoh4(pullRefreshState2, refreshing, $this$komponent_u24lambda_u240_u248_u2412.align(Modifier.Companion, Alignment.Companion.getTopCenter()), 0L, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBrand_pink-0d7_KjU(), 0.0f, $composer, PullToRefreshDefaults.$stable << 18, 40);
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

                                public SpaceCheesePageModel$komponent$1$1 getState() {
                                    return this.state;
                                }

                                public HostConfiguration getPreferredHostConfiguration() {
                                    return this.$this_setContent.getPreferredHostConfiguration();
                                }
                            };
                            return $this$Komponent.__setContent(content$iv$iv);
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public static final PageState komponent$lambda$0$0(MutableState<PageState> mutableState) {
                            State $this$getValue$iv = (State) mutableState;
                            return (PageState) $this$getValue$iv.getValue();
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public static final void komponent$lambda$0$refreshData(KomponentScope<? super SpaceCheesePageState> komponentScope, SpaceCheesePageModel this$0, MutableState<PageState> mutableState) {
                            KomponentHostScope.-CC.launch$default((KomponentHostScope) komponentScope, (CoroutineContext) null, (CoroutineStart) null, new SpaceCheesePageModel$komponent$1$refreshData$1(this$0, mutableState, komponentScope, null), 3, (Object) null);
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public static final void komponent$lambda$0$Failure(KomponentScope<? super SpaceCheesePageState> komponentScope, MutableState<PageState> mutableState, SpaceCheesePageModel this$0, boolean isNetworkError, Modifier modifier, Composer $composer, int $changed, int i) {
                            Modifier modifier2;
                            ComposerKt.sourceInformationMarkerStart($composer, -62640633, "C(Failure)N(isNetworkError,modifier)82@3163L21:SpaceCheesePageModel.kt#mv22nr");
                            if ((i & 2) != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-62640633, $changed, -1, "kntr.app.cheese.space.SpaceCheesePageModel.komponent.<anonymous>.Failure (SpaceCheesePageModel.kt:79)");
                            }
                            Modifier placeholderModifier = ScrollKt.verticalScroll$default(modifier2, ScrollKt.rememberScrollState(0, $composer, 0, 1), false, (FlingBehavior) null, false, 14, (Object) null);
                            if (isNetworkError) {
                                $composer.startReplaceGroup(-2110969736);
                                ComposerKt.sourceInformation($composer, "85@3305L13,84@3252L243");
                                ComposerKt.sourceInformationMarkerStart($composer, -68093548, "CC(remember):SpaceCheesePageModel.kt#9igjgp");
                                boolean invalid$iv = $composer.changedInstance(komponentScope) | $composer.changed(mutableState) | $composer.changedInstance(this$0);
                                Object it$iv = $composer.rememberedValue();
                                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                                    Object value$iv = (KFunction) new SpaceCheesePageModel$komponent$1$Failure$1$1(komponentScope, this$0, mutableState);
                                    $composer.updateRememberedValue(value$iv);
                                    it$iv = value$iv;
                                }
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                NetworkErrorPlaceholderKt.NetworkErrorPlaceholder((KFunction) it$iv, placeholderModifier, (Painter) null, (String) null, "网络错误，请重试", "再试一次", $composer, 221184, 12);
                                $composer.endReplaceGroup();
                            } else {
                                $composer.startReplaceGroup(-2110680847);
                                ComposerKt.sourceInformation($composer, "91@3572L13,91@3549L58");
                                ComposerKt.sourceInformationMarkerStart($composer, -68085004, "CC(remember):SpaceCheesePageModel.kt#9igjgp");
                                boolean invalid$iv2 = $composer.changedInstance(komponentScope) | $composer.changed(mutableState) | $composer.changedInstance(this$0);
                                Object it$iv2 = $composer.rememberedValue();
                                if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                                    Object value$iv2 = (KFunction) new SpaceCheesePageModel$komponent$1$Failure$2$1(komponentScope, this$0, mutableState);
                                    $composer.updateRememberedValue(value$iv2);
                                    it$iv2 = value$iv2;
                                }
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                LoadFailurePlaceholderKt.LoadFailurePlaceholder((KFunction) it$iv2, placeholderModifier, (Painter) null, (String) null, (String) null, (String) null, $composer, 0, 60);
                                $composer.endReplaceGroup();
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            ComposerKt.sourceInformationMarkerEnd($composer);
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public static final UiComposableLike<Unit> komponent$lambda$0$7(State<? extends UiComposableLike<Unit>> state) {
                            Object thisObj$iv = state.getValue();
                            return (UiComposableLike) thisObj$iv;
                        }
                    }