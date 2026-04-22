package kntr.app.im.chat.service;

import im.base.IMLog;
import im.base.config.IMConfigSetting;
import java.util.LinkedHashMap;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.core.model.MessageId;
import kntr.app.im.chat.core.service.MessageTask;
import kntr.app.im.chat.network.ChatSendEvent;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.time.Duration;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: MessageSendServiceImpl.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.service.MessageSendServiceImpl$start$4", f = "MessageSendServiceImpl.kt", i = {}, l = {122}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class MessageSendServiceImpl$start$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MessageSendServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageSendServiceImpl$start$4(MessageSendServiceImpl messageSendServiceImpl, Continuation<? super MessageSendServiceImpl$start$4> continuation) {
        super(2, continuation);
        this.this$0 = messageSendServiceImpl;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MessageSendServiceImpl$start$4(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        final Flow $this$mapNotNull$iv;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                $this$mapNotNull$iv = this.this$0.getStateFlow();
                this.label = 1;
                if (new Flow<MessageTask>() { // from class: kntr.app.im.chat.service.MessageSendServiceImpl$start$4$invokeSuspend$$inlined$mapNotNull$1

                    /* compiled from: Emitters.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
                    /* renamed from: kntr.app.im.chat.service.MessageSendServiceImpl$start$4$invokeSuspend$$inlined$mapNotNull$1$2  reason: invalid class name */
                    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        /* compiled from: Emitters.kt */
                        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                        @DebugMetadata(c = "kntr.app.im.chat.service.MessageSendServiceImpl$start$4$invokeSuspend$$inlined$mapNotNull$1$2", f = "MessageSendServiceImpl.kt", i = {0, 0, 0, 0, 0, 0}, l = {238}, m = "emit", n = {"value", "$completion", "value", "$this$mapNotNull_u24lambda_u246", "transformed", "$i$a$-unsafeTransform-FlowKt__TransformKt$mapNotNull$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
                        /* renamed from: kntr.app.im.chat.service.MessageSendServiceImpl$start$4$invokeSuspend$$inlined$mapNotNull$1$2$1  reason: invalid class name */
                        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                        public static final class AnonymousClass1 extends ContinuationImpl {
                            int I$0;
                            Object L$0;
                            Object L$1;
                            Object L$2;
                            Object L$3;
                            Object L$4;
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

                        public AnonymousClass2(FlowCollector flowCollector) {
                            this.$this_unsafeFlow = flowCollector;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
                        /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
                        /* JADX WARN: Removed duplicated region for block: B:13:0x0049  */
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final Object emit(Object value, Continuation $completion) {
                            Continuation $continuation;
                            Object obj;
                            Object element$iv;
                            if ($completion instanceof AnonymousClass1) {
                                $continuation = (AnonymousClass1) $completion;
                                if (($continuation.label & Integer.MIN_VALUE) != 0) {
                                    $continuation.label -= Integer.MIN_VALUE;
                                    Object $result = $continuation.result;
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    switch ($continuation.label) {
                                        case 0:
                                            ResultKt.throwOnFailure($result);
                                            FlowCollector $this$mapNotNull_u24lambda_u246 = this.$this_unsafeFlow;
                                            AnonymousClass1 anonymousClass1 = $continuation;
                                            final LinkedHashMap taskMap = (LinkedHashMap) value;
                                            IMLog.Companion.d("MessageSendService", 
                                            /*  JADX ERROR: Method code generation error
                                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0066: INVOKE  
                                                  (wrap: im.base.IMLog$Companion : 0x005a: SGET  (r12v0 im.base.IMLog$Companion A[REMOVE]) =  im.base.IMLog.Companion im.base.IMLog$Companion)
                                                  ("MessageSendService")
                                                  (wrap: kotlin.jvm.functions.Function0<java.lang.String> : 0x005f: CONSTRUCTOR  (r13v0 kotlin.jvm.functions.Function0<java.lang.String> A[REMOVE]) = (r10v1 'taskMap' java.util.LinkedHashMap A[D('taskMap' java.util.LinkedHashMap), DONT_INLINE]) call: kntr.app.im.chat.service.MessageSendServiceImpl$start$4$1$1.<init>(java.util.LinkedHashMap):void type: CONSTRUCTOR)
                                                 type: VIRTUAL call: im.base.IMLog.Companion.d(java.lang.String, kotlin.jvm.functions.Function0):void in method: kntr.app.im.chat.service.MessageSendServiceImpl$start$4$invokeSuspend$$inlined$mapNotNull$1.2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object, file: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex
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
                                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: kntr.app.im.chat.service.MessageSendServiceImpl$start$4$1$1, state: NOT_LOADED
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
                                                Method dump skipped, instructions count: 320
                                                To view this dump change 'Code comments level' option to 'DEBUG'
                                            */
                                            throw new UnsupportedOperationException("Method not decompiled: kntr.app.im.chat.service.MessageSendServiceImpl$start$4$invokeSuspend$$inlined$mapNotNull$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                                        }
                                    }

                                    public Object collect(FlowCollector collector, Continuation $completion) {
                                        Object collect = $this$mapNotNull$iv.collect(new AnonymousClass2(collector), $completion);
                                        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                                    }
                                }.collect(new AnonymousClass2(this.this$0), (Continuation) this) == coroutine_suspended) {
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

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* compiled from: MessageSendServiceImpl.kt */
                    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                    /* renamed from: kntr.app.im.chat.service.MessageSendServiceImpl$start$4$2  reason: invalid class name */
                    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ MessageSendServiceImpl this$0;

                        AnonymousClass2(MessageSendServiceImpl messageSendServiceImpl) {
                            this.this$0 = messageSendServiceImpl;
                        }

                        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                            return emit((MessageTask) value, (Continuation<? super Unit>) $completion);
                        }

                        /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
                        /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
                        /* JADX WARN: Removed duplicated region for block: B:13:0x0045  */
                        /* JADX WARN: Removed duplicated region for block: B:14:0x005a  */
                        /* JADX WARN: Removed duplicated region for block: B:15:0x006a  */
                        /* JADX WARN: Removed duplicated region for block: B:21:0x00a5  */
                        /* JADX WARN: Removed duplicated region for block: B:27:0x013c A[RETURN] */
                        /* JADX WARN: Removed duplicated region for block: B:28:0x013d  */
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final Object emit(MessageTask it, Continuation<? super Unit> continuation) {
                            MessageSendServiceImpl$start$4$2$emit$1 messageSendServiceImpl$start$4$2$emit$1;
                            MessageTask it2;
                            Object obj;
                            MessageSendServiceImpl messageSendServiceImpl;
                            IMConfigSetting iMConfigSetting;
                            ChatSendEvent chatSendEvent;
                            EntityMessage it3;
                            MessageTask it4;
                            int i;
                            IMConfigSetting iMConfigSetting2;
                            long j2;
                            MessageTask it5;
                            if (continuation instanceof MessageSendServiceImpl$start$4$2$emit$1) {
                                messageSendServiceImpl$start$4$2$emit$1 = (MessageSendServiceImpl$start$4$2$emit$1) continuation;
                                if ((messageSendServiceImpl$start$4$2$emit$1.label & Integer.MIN_VALUE) != 0) {
                                    messageSendServiceImpl$start$4$2$emit$1.label -= Integer.MIN_VALUE;
                                    Object $result = messageSendServiceImpl$start$4$2$emit$1.result;
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    switch (messageSendServiceImpl$start$4$2$emit$1.label) {
                                        case 0:
                                            ResultKt.throwOnFailure($result);
                                            IMLog.Companion.i("MessageSendService", "准备发送消息: " + it.getToken());
                                            messageSendServiceImpl$start$4$2$emit$1.L$0 = SpillingKt.nullOutSpilledVariable(it);
                                            messageSendServiceImpl$start$4$2$emit$1.label = 1;
                                            it2 = it;
                                            Object mo1358sendIoAF18A = it2.mo1358sendIoAF18A(messageSendServiceImpl$start$4$2$emit$1);
                                            if (mo1358sendIoAF18A == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            obj = mo1358sendIoAF18A;
                                            messageSendServiceImpl = this.this$0;
                                            if (Result.isSuccess-impl(obj)) {
                                                EntityMessage it6 = (EntityMessage) obj;
                                                IMLog.Companion companion = IMLog.Companion;
                                                MessageId msgId = it6.getMsgId();
                                                String token = it6.getToken();
                                                iMConfigSetting = messageSendServiceImpl.imConfigSetting;
                                                companion.i("MessageSendService", "消息发送成功: " + msgId + " for task " + token + ", 延迟 " + Duration.toString-impl(iMConfigSetting.getChatSendDelayDuration-UwyO8pc()) + " 发送下一个");
                                                chatSendEvent = messageSendServiceImpl.sendEvent;
                                                MessageId msgId2 = it6.getMsgId();
                                                messageSendServiceImpl$start$4$2$emit$1.L$0 = SpillingKt.nullOutSpilledVariable(it2);
                                                messageSendServiceImpl$start$4$2$emit$1.L$1 = obj;
                                                messageSendServiceImpl$start$4$2$emit$1.L$2 = messageSendServiceImpl;
                                                messageSendServiceImpl$start$4$2$emit$1.L$3 = SpillingKt.nullOutSpilledVariable(it6);
                                                messageSendServiceImpl$start$4$2$emit$1.I$0 = 0;
                                                messageSendServiceImpl$start$4$2$emit$1.label = 2;
                                                if (chatSendEvent.notifyNewMessageSent(msgId2, messageSendServiceImpl$start$4$2$emit$1) == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                                it3 = it6;
                                                it4 = it2;
                                                i = 0;
                                                iMConfigSetting2 = messageSendServiceImpl.imConfigSetting;
                                                j2 = iMConfigSetting2.getChatSendDelayDuration-UwyO8pc();
                                                messageSendServiceImpl$start$4$2$emit$1.L$0 = SpillingKt.nullOutSpilledVariable(it4);
                                                messageSendServiceImpl$start$4$2$emit$1.L$1 = obj;
                                                messageSendServiceImpl$start$4$2$emit$1.L$2 = SpillingKt.nullOutSpilledVariable(it3);
                                                messageSendServiceImpl$start$4$2$emit$1.L$3 = null;
                                                messageSendServiceImpl$start$4$2$emit$1.I$0 = i;
                                                messageSendServiceImpl$start$4$2$emit$1.label = 3;
                                                if (DelayKt.delay-VtjQ1oo(j2, messageSendServiceImpl$start$4$2$emit$1) != coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                                it5 = it4;
                                            }
                                            return Unit.INSTANCE;
                                        case 1:
                                            it2 = (MessageTask) messageSendServiceImpl$start$4$2$emit$1.L$0;
                                            ResultKt.throwOnFailure($result);
                                            obj = ((Result) $result).unbox-impl();
                                            messageSendServiceImpl = this.this$0;
                                            if (Result.isSuccess-impl(obj)) {
                                            }
                                            return Unit.INSTANCE;
                                        case 2:
                                            i = messageSendServiceImpl$start$4$2$emit$1.I$0;
                                            it3 = (EntityMessage) messageSendServiceImpl$start$4$2$emit$1.L$3;
                                            messageSendServiceImpl = (MessageSendServiceImpl) messageSendServiceImpl$start$4$2$emit$1.L$2;
                                            obj = messageSendServiceImpl$start$4$2$emit$1.L$1;
                                            it4 = (MessageTask) messageSendServiceImpl$start$4$2$emit$1.L$0;
                                            ResultKt.throwOnFailure($result);
                                            iMConfigSetting2 = messageSendServiceImpl.imConfigSetting;
                                            j2 = iMConfigSetting2.getChatSendDelayDuration-UwyO8pc();
                                            messageSendServiceImpl$start$4$2$emit$1.L$0 = SpillingKt.nullOutSpilledVariable(it4);
                                            messageSendServiceImpl$start$4$2$emit$1.L$1 = obj;
                                            messageSendServiceImpl$start$4$2$emit$1.L$2 = SpillingKt.nullOutSpilledVariable(it3);
                                            messageSendServiceImpl$start$4$2$emit$1.L$3 = null;
                                            messageSendServiceImpl$start$4$2$emit$1.I$0 = i;
                                            messageSendServiceImpl$start$4$2$emit$1.label = 3;
                                            if (DelayKt.delay-VtjQ1oo(j2, messageSendServiceImpl$start$4$2$emit$1) != coroutine_suspended) {
                                            }
                                            break;
                                        case 3:
                                            int i2 = messageSendServiceImpl$start$4$2$emit$1.I$0;
                                            EntityMessage entityMessage = (EntityMessage) messageSendServiceImpl$start$4$2$emit$1.L$2;
                                            Object obj2 = messageSendServiceImpl$start$4$2$emit$1.L$1;
                                            it5 = (MessageTask) messageSendServiceImpl$start$4$2$emit$1.L$0;
                                            ResultKt.throwOnFailure($result);
                                            return Unit.INSTANCE;
                                        default:
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                }
                            }
                            messageSendServiceImpl$start$4$2$emit$1 = new MessageSendServiceImpl$start$4$2$emit$1(this, continuation);
                            Object $result2 = messageSendServiceImpl$start$4$2$emit$1.result;
                            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (messageSendServiceImpl$start$4$2$emit$1.label) {
                            }
                        }
                    }
                }