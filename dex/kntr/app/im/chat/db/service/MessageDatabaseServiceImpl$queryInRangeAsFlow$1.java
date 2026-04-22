package kntr.app.im.chat.db.service;

import im.base.IMLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.db.SessionIdDbConverters;
import kntr.app.im.chat.db.dao.SessionMessageDao;
import kntr.app.im.chat.db.entity.SessionIdEntity;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.LongRange;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.datetime.Instant;
import kotlinx.serialization.json.Json;

/* compiled from: MessageDatabaseServiceImpl.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/flow/FlowCollector;", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/core/model/EntityMessage;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.db.service.MessageDatabaseServiceImpl$queryInRangeAsFlow$1", f = "MessageDatabaseServiceImpl.kt", i = {0, 0}, l = {89}, m = "invokeSuspend", n = {"$this$flow", "result"}, s = {"L$0", "L$1"}, v = 1)
final class MessageDatabaseServiceImpl$queryInRangeAsFlow$1 extends SuspendLambda implements Function2<FlowCollector<? super List<? extends EntityMessage>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Instant $baselineTime;
    final /* synthetic */ LongRange $range;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ MessageDatabaseServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageDatabaseServiceImpl$queryInRangeAsFlow$1(MessageDatabaseServiceImpl messageDatabaseServiceImpl, LongRange longRange, Instant instant, Continuation<? super MessageDatabaseServiceImpl$queryInRangeAsFlow$1> continuation) {
        super(2, continuation);
        this.this$0 = messageDatabaseServiceImpl;
        this.$range = longRange;
        this.$baselineTime = instant;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> messageDatabaseServiceImpl$queryInRangeAsFlow$1 = new MessageDatabaseServiceImpl$queryInRangeAsFlow$1(this.this$0, this.$range, this.$baselineTime, continuation);
        messageDatabaseServiceImpl$queryInRangeAsFlow$1.L$0 = obj;
        return messageDatabaseServiceImpl$queryInRangeAsFlow$1;
    }

    public final Object invoke(FlowCollector<? super List<EntityMessage>> flowCollector, Continuation<? super Unit> continuation) {
        return create(flowCollector, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        SessionMessageDao sessionMessageDao;
        SessionIdEntity sessionIdEntity;
        FlowCollector $this$flow = (FlowCollector) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                sessionMessageDao = this.this$0.sessionMessageDao;
                sessionIdEntity = this.this$0.sessionId;
                final Flow $this$map$iv = FlowKt.distinctUntilChanged(sessionMessageDao.queryInRangeAndLatestAsFlow(sessionIdEntity, this.$range.getFirst(), this.$range.getLast(), this.$baselineTime.toEpochMilliseconds()));
                final LongRange longRange = this.$range;
                final Instant instant = this.$baselineTime;
                final MessageDatabaseServiceImpl messageDatabaseServiceImpl = this.this$0;
                Flow result = new Flow<List<? extends EntityMessage>>() { // from class: kntr.app.im.chat.db.service.MessageDatabaseServiceImpl$queryInRangeAsFlow$1$invokeSuspend$$inlined$map$1

                    /* compiled from: Emitters.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
                    /* renamed from: kntr.app.im.chat.db.service.MessageDatabaseServiceImpl$queryInRangeAsFlow$1$invokeSuspend$$inlined$map$1$2  reason: invalid class name */
                    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ Instant $baselineTime$inlined;
                        final /* synthetic */ LongRange $range$inlined;
                        final /* synthetic */ FlowCollector $this_unsafeFlow;
                        final /* synthetic */ MessageDatabaseServiceImpl this$0;

                        /* compiled from: Emitters.kt */
                        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                        @DebugMetadata(c = "kntr.app.im.chat.db.service.MessageDatabaseServiceImpl$queryInRangeAsFlow$1$invokeSuspend$$inlined$map$1$2", f = "MessageDatabaseServiceImpl.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {236, 219}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$completion", "it", "$this$mapNotNull$iv", "$this$mapNotNullTo$iv$iv", "destination$iv$iv", "$this$forEach$iv$iv$iv", "element$iv$iv$iv", "element$iv$iv", "it", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1", "$i$a$-map-MessageDatabaseServiceImpl$queryInRangeAsFlow$1$result$1", "$i$f$mapNotNull", "$i$f$mapNotNullTo", "$i$f$forEach", "$i$a$-forEach-CollectionsKt___CollectionsKt$mapNotNullTo$1$iv$iv", "$i$a$-mapNotNull-MessageDatabaseServiceImpl$queryInRangeAsFlow$1$result$1$2", "value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$12", "L$13", "L$14", "I$0", "I$1", "I$2", "I$3", "I$4", "I$5", "I$6", "L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                        /* renamed from: kntr.app.im.chat.db.service.MessageDatabaseServiceImpl$queryInRangeAsFlow$1$invokeSuspend$$inlined$map$1$2$1  reason: invalid class name */
                        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                        public static final class AnonymousClass1 extends ContinuationImpl {
                            int I$0;
                            int I$1;
                            int I$2;
                            int I$3;
                            int I$4;
                            int I$5;
                            int I$6;
                            Object L$0;
                            Object L$1;
                            Object L$10;
                            Object L$11;
                            Object L$12;
                            Object L$13;
                            Object L$14;
                            Object L$2;
                            Object L$3;
                            Object L$4;
                            Object L$5;
                            Object L$6;
                            Object L$7;
                            Object L$8;
                            Object L$9;
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

                        public AnonymousClass2(FlowCollector flowCollector, LongRange longRange, Instant instant, MessageDatabaseServiceImpl messageDatabaseServiceImpl) {
                            this.$this_unsafeFlow = flowCollector;
                            this.$range$inlined = longRange;
                            this.$baselineTime$inlined = instant;
                            this.this$0 = messageDatabaseServiceImpl;
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
                        /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
                        /* JADX WARN: Removed duplicated region for block: B:13:0x0043  */
                        /* JADX WARN: Removed duplicated region for block: B:14:0x00c0  */
                        /* JADX WARN: Removed duplicated region for block: B:17:0x0113  */
                        /* JADX WARN: Removed duplicated region for block: B:23:0x01d8  */
                        /* JADX WARN: Removed duplicated region for block: B:25:0x01f5  */
                        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x01b5 -> B:21:0x01d4). Please submit an issue!!! */
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final Object emit(Object value, Continuation $completion) {
                            Continuation $continuation;
                            int $i$f$forEach;
                            Continuation $completion2;
                            final List it;
                            List $this$mapNotNull$iv;
                            Collection destination$iv$iv;
                            Iterable $this$forEach$iv$iv$iv;
                            Iterator<T> it2;
                            Object obj;
                            AnonymousClass1 anonymousClass1;
                            int $i$f$mapNotNull;
                            Object value2;
                            AnonymousClass2 anonymousClass2;
                            int $i$f$mapNotNullTo;
                            int $i$f$mapNotNullTo2;
                            AnonymousClass1 anonymousClass12;
                            int i;
                            FlowCollector $this$map_u24lambda_u245;
                            Object value3;
                            Continuation value4;
                            Object $result;
                            FlowCollector flowCollector;
                            Iterable $this$mapNotNullTo$iv$iv;
                            Json json;
                            SessionIdDbConverters sessionIdDbConverters;
                            AnonymousClass2 anonymousClass22;
                            int $i$f$mapNotNullTo3;
                            AnonymousClass1 anonymousClass13;
                            Iterable $this$mapNotNull$iv2;
                            Object obj2;
                            FlowCollector $this$map_u24lambda_u2452;
                            int i2;
                            Continuation $completion3;
                            Object obj3;
                            Object value5;
                            FlowCollector flowCollector2;
                            Collection destination$iv$iv2;
                            Iterator<T> it3;
                            Iterable $this$mapNotNullTo$iv$iv2;
                            EntityMessage entityMessage;
                            if ($completion instanceof AnonymousClass1) {
                                AnonymousClass1 anonymousClass14 = (AnonymousClass1) $completion;
                                if ((anonymousClass14.label & Integer.MIN_VALUE) != 0) {
                                    anonymousClass14.label -= Integer.MIN_VALUE;
                                    $continuation = anonymousClass14;
                                    Object $result2 = $continuation.result;
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    switch ($continuation.label) {
                                        case 0:
                                            ResultKt.throwOnFailure($result2);
                                            FlowCollector $this$map_u24lambda_u2453 = this.$this_unsafeFlow;
                                            AnonymousClass1 anonymousClass15 = $continuation;
                                            $i$f$forEach = 0;
                                            $completion2 = $continuation;
                                            it = (List) value;
                                            IMLog.Companion companion = IMLog.Companion;
                                            final LongRange longRange = this.$range$inlined;
                                            final Instant instant = this.$baselineTime$inlined;
                                            final MessageDatabaseServiceImpl messageDatabaseServiceImpl = this.this$0;
                                            companion.d("ChatDatabaseServiceImpl", 
                                            /*  JADX ERROR: Method code generation error
                                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00e1: INVOKE  
                                                  (r11v0 'companion' im.base.IMLog$Companion)
                                                  ("ChatDatabaseServiceImpl")
                                                  (wrap: kotlin.jvm.functions.Function0<java.lang.String> : 0x00da: CONSTRUCTOR  (r12v0 kotlin.jvm.functions.Function0<java.lang.String> A[REMOVE]) = 
                                                  (r13v0 'longRange' kotlin.ranges.LongRange A[DONT_INLINE])
                                                  (r14v0 'instant' kotlinx.datetime.Instant A[DONT_INLINE])
                                                  (r15v0 'messageDatabaseServiceImpl' kntr.app.im.chat.db.service.MessageDatabaseServiceImpl A[DONT_INLINE])
                                                  (r9v1 'it' java.util.List A[D('it' java.util.List), DONT_INLINE])
                                                 call: kntr.app.im.chat.db.service.MessageDatabaseServiceImpl$queryInRangeAsFlow$1$result$1$1.<init>(kotlin.ranges.LongRange, kotlinx.datetime.Instant, kntr.app.im.chat.db.service.MessageDatabaseServiceImpl, java.util.List):void type: CONSTRUCTOR)
                                                 type: VIRTUAL call: im.base.IMLog.Companion.d(java.lang.String, kotlin.jvm.functions.Function0):void in method: kntr.app.im.chat.db.service.MessageDatabaseServiceImpl$queryInRangeAsFlow$1$invokeSuspend$$inlined$map$1.2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object, file: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex
                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:309)
                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:272)
                                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
                                                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
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
                                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: kntr.app.im.chat.db.service.MessageDatabaseServiceImpl$queryInRangeAsFlow$1$result$1$1, state: NOT_LOADED
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
                                                	... 33 more
                                                */
                                            /*
                                                Method dump skipped, instructions count: 604
                                                To view this dump change 'Code comments level' option to 'DEBUG'
                                            */
                                            throw new UnsupportedOperationException("Method not decompiled: kntr.app.im.chat.db.service.MessageDatabaseServiceImpl$queryInRangeAsFlow$1$invokeSuspend$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                                        }
                                    }

                                    public Object collect(FlowCollector collector, Continuation $completion) {
                                        Object collect = $this$map$iv.collect(new AnonymousClass2(collector, longRange, instant, messageDatabaseServiceImpl), $completion);
                                        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                                    }
                                };
                                this.L$0 = SpillingKt.nullOutSpilledVariable($this$flow);
                                this.L$1 = SpillingKt.nullOutSpilledVariable(result);
                                this.label = 1;
                                if (FlowKt.emitAll($this$flow, result, (Continuation) this) != coroutine_suspended) {
                                    break;
                                } else {
                                    return coroutine_suspended;
                                }
                            case 1:
                                Flow flow = (Flow) this.L$1;
                                ResultKt.throwOnFailure($result);
                                break;
                            default:
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        return Unit.INSTANCE;
                    }
                }