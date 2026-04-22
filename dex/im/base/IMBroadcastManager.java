package im.base;

import com.bapis.bilibili.broadcast.message.im.KCmdId;
import com.bapis.bilibili.broadcast.message.im.KCommandMsg;
import com.bapis.bilibili.broadcast.message.im.KNotifyRsp;
import com.bapis.bilibili.broadcast.message.im.KReqServerNotify;
import com.tencent.smtt.sdk.TbsListener;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.reflect.KType;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.serialization.BinaryFormat;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.protobuf.ProtoBuf;

/* compiled from: IMBroadcastManager.kt */
@Singleton
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J(\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0000\u0010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\r0\u0011J\u001f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\u0006\b\u0000\u0010\r\u0018\u00012\u0006\u0010\u000e\u001a\u00020\u000fH\u0086\bJ\u0012\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\fJ\u001b\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\n\b\u0000\u0010\r\u0018\u0001*\u00020\u0016H\u0086\bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lim/base/IMBroadcastManager;", "", "platformService", "Lim/base/IMBroadCastPlatformService;", "<init>", "(Lim/base/IMBroadCastPlatformService;)V", "imBroadCastScope", "Lkotlinx/coroutines/CoroutineScope;", "mossFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "Lcom/bapis/bilibili/broadcast/message/im/KNotifyRsp;", "ofCommandType", "Lkotlinx/coroutines/flow/Flow;", "T", "commandType", "Lcom/bapis/bilibili/broadcast/message/im/KCmdId;", "serializer", "Lkotlinx/serialization/KSerializer;", "commandList", "", "Lcom/bapis/bilibili/broadcast/message/im/KCommandMsg;", "ofCommandList", "Lcom/bapis/bilibili/broadcast/message/im/KCommandMsg$ICommand;", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMBroadcastManager {
    private final CoroutineScope imBroadCastScope;
    private final SharedFlow<KNotifyRsp> mossFlow;

    @Inject
    public IMBroadcastManager(IMBroadCastPlatformService platformService) {
        Intrinsics.checkNotNullParameter(platformService, "platformService");
        this.imBroadCastScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain()));
        this.mossFlow = FlowKt.shareIn(platformService.startFlow(), this.imBroadCastScope, SharingStarted.Companion.getLazily(), 0);
    }

    public final <T> Flow<T> ofCommandType(final KCmdId commandType, final KSerializer<T> kSerializer) {
        Intrinsics.checkNotNullParameter(commandType, "commandType");
        Intrinsics.checkNotNullParameter(kSerializer, "serializer");
        final Flow $this$filter$iv = this.mossFlow;
        final Flow $this$map$iv = new Flow<KNotifyRsp>() { // from class: im.base.IMBroadcastManager$ofCommandType$$inlined$filter$1

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
            /* renamed from: im.base.IMBroadcastManager$ofCommandType$$inlined$filter$1$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ KCmdId $commandType$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "im.base.IMBroadcastManager$ofCommandType$$inlined$filter$1$2", f = "IMBroadcastManager.kt", i = {0, 0, 0, 0, 0}, l = {TbsListener.ErrorCode.RENAME_EXCEPTION}, m = "emit", n = {"value", "$completion", "value", "$this$filter_u24lambda_u240", "$i$a$-unsafeTransform-FlowKt__TransformKt$filter$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                /* renamed from: im.base.IMBroadcastManager$ofCommandType$$inlined$filter$1$2$1  reason: invalid class name */
                /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
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

                public AnonymousClass2(FlowCollector flowCollector, KCmdId kCmdId) {
                    this.$this_unsafeFlow = flowCollector;
                    this.$commandType$inlined = kCmdId;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
                /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
                /* JADX WARN: Removed duplicated region for block: B:13:0x0042  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object value, Continuation $completion) {
                    Continuation $continuation;
                    if ($completion instanceof AnonymousClass1) {
                        $continuation = (AnonymousClass1) $completion;
                        if (($continuation.label & Integer.MIN_VALUE) != 0) {
                            $continuation.label -= Integer.MIN_VALUE;
                            Object $result = $continuation.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch ($continuation.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    FlowCollector $this$filter_u24lambda_u240 = this.$this_unsafeFlow;
                                    AnonymousClass1 anonymousClass1 = $continuation;
                                    KNotifyRsp it = (KNotifyRsp) value;
                                    if (!(it.getCmd() == ((long) this.$commandType$inlined.getValue()))) {
                                        break;
                                    } else {
                                        $continuation.L$0 = SpillingKt.nullOutSpilledVariable(value);
                                        $continuation.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                        $continuation.L$2 = SpillingKt.nullOutSpilledVariable(value);
                                        $continuation.L$3 = SpillingKt.nullOutSpilledVariable($this$filter_u24lambda_u240);
                                        $continuation.I$0 = 0;
                                        $continuation.label = 1;
                                        if ($this$filter_u24lambda_u240.emit(value, $continuation) != coroutine_suspended) {
                                            break;
                                        } else {
                                            return coroutine_suspended;
                                        }
                                    }
                                case 1:
                                    int i2 = $continuation.I$0;
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

            public Object collect(FlowCollector collector, Continuation $completion) {
                Object collect = $this$filter$iv.collect(new AnonymousClass2(collector, commandType), $completion);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        };
        return new Flow<T>() { // from class: im.base.IMBroadcastManager$ofCommandType$$inlined$map$1

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
            /* renamed from: im.base.IMBroadcastManager$ofCommandType$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ KSerializer $serializer$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "im.base.IMBroadcastManager$ofCommandType$$inlined$map$1$2", f = "IMBroadcastManager.kt", i = {0, 0, 0, 0, 0}, l = {TbsListener.ErrorCode.RENAME_EXCEPTION}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                /* renamed from: im.base.IMBroadcastManager$ofCommandType$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
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

                public AnonymousClass2(FlowCollector flowCollector, KSerializer kSerializer) {
                    this.$this_unsafeFlow = flowCollector;
                    this.$serializer$inlined = kSerializer;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
                /* JADX WARN: Removed duplicated region for block: B:13:0x003e  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object value, Continuation $completion) {
                    Continuation $continuation;
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
                                    KNotifyRsp it = (KNotifyRsp) value;
                                    Object decodeFromByteArray = ProtoBuf.Default.decodeFromByteArray(this.$serializer$inlined, it.getPayload());
                                    $continuation.L$0 = SpillingKt.nullOutSpilledVariable(value);
                                    $continuation.L$1 = SpillingKt.nullOutSpilledVariable($continuation);
                                    $continuation.L$2 = SpillingKt.nullOutSpilledVariable(value);
                                    $continuation.L$3 = SpillingKt.nullOutSpilledVariable($this$map_u24lambda_u245);
                                    $continuation.I$0 = 0;
                                    $continuation.label = 1;
                                    if ($this$map_u24lambda_u245.emit(decodeFromByteArray, $continuation) != coroutine_suspended) {
                                        break;
                                    } else {
                                        return coroutine_suspended;
                                    }
                                case 1:
                                    int i2 = $continuation.I$0;
                                    FlowCollector flowCollector = (FlowCollector) $continuation.L$3;
                                    Object obj = $continuation.L$2;
                                    AnonymousClass1 anonymousClass1 = (AnonymousClass1) $continuation.L$1;
                                    Object value2 = $continuation.L$0;
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

            public Object collect(FlowCollector collector, Continuation $completion) {
                Object collect = $this$map$iv.collect(new AnonymousClass2(collector, kSerializer), $completion);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        };
    }

    public final /* synthetic */ <T> Flow<T> ofCommandType(KCmdId commandType) {
        Intrinsics.checkNotNullParameter(commandType, "commandType");
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
        return ofCommandType(commandType, SerializersKt.serializer((KType) null));
    }

    public final Flow<List<KCommandMsg>> commandList() {
        final Flow $this$mapNotNull$iv = this.mossFlow;
        return new Flow<List<? extends KCommandMsg>>() { // from class: im.base.IMBroadcastManager$commandList$$inlined$mapNotNull$1

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
            /* renamed from: im.base.IMBroadcastManager$commandList$$inlined$mapNotNull$1$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "im.base.IMBroadcastManager$commandList$$inlined$mapNotNull$1$2", f = "IMBroadcastManager.kt", i = {0, 0, 0, 0, 0, 0}, l = {TbsListener.ErrorCode.HOST_CONTEXT_IS_NULL}, m = "emit", n = {"value", "$completion", "value", "$this$mapNotNull_u24lambda_u246", "transformed", "$i$a$-unsafeTransform-FlowKt__TransformKt$mapNotNull$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
                /* renamed from: im.base.IMBroadcastManager$commandList$$inlined$mapNotNull$1$2$1  reason: invalid class name */
                /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
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

                /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
                /* JADX WARN: Removed duplicated region for block: B:12:0x0031  */
                /* JADX WARN: Removed duplicated region for block: B:13:0x0048  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object value, Continuation $completion) {
                    AnonymousClass1 anonymousClass1;
                    AnonymousClass1 anonymousClass12;
                    List list;
                    if ($completion instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) $completion;
                        if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label -= Integer.MIN_VALUE;
                            anonymousClass12 = anonymousClass1;
                            Object $result = anonymousClass12.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (anonymousClass12.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    FlowCollector $this$mapNotNull_u24lambda_u246 = this.$this_unsafeFlow;
                                    Continuation continuation = (Continuation) anonymousClass12;
                                    KNotifyRsp it = (KNotifyRsp) value;
                                    try {
                                        BinaryFormat $this$decodeFromByteArray$iv = ProtoBuf.Default;
                                        byte[] bytes$iv = it.getPayload();
                                        $this$decodeFromByteArray$iv.getSerializersModule();
                                        list = ((KReqServerNotify) $this$decodeFromByteArray$iv.decodeFromByteArray(KReqServerNotify.Companion.serializer(), bytes$iv)).getCommandMsgs();
                                    } catch (SerializationException e2) {
                                        KLog_androidKt.getKLog().e(IMBroadcastManagerKt.TAG, "Fail to decode KReqServerNotify from broadcast msg id " + it.getCmd(), e2);
                                        list = null;
                                    }
                                    if (list == null) {
                                        break;
                                    } else {
                                        anonymousClass12.L$0 = SpillingKt.nullOutSpilledVariable(value);
                                        anonymousClass12.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass12);
                                        anonymousClass12.L$2 = SpillingKt.nullOutSpilledVariable(value);
                                        anonymousClass12.L$3 = SpillingKt.nullOutSpilledVariable($this$mapNotNull_u24lambda_u246);
                                        anonymousClass12.L$4 = SpillingKt.nullOutSpilledVariable(list);
                                        anonymousClass12.I$0 = 0;
                                        anonymousClass12.label = 1;
                                        if ($this$mapNotNull_u24lambda_u246.emit(list, anonymousClass12) != coroutine_suspended) {
                                            break;
                                        } else {
                                            return coroutine_suspended;
                                        }
                                    }
                                case 1:
                                    int i2 = anonymousClass12.I$0;
                                    List list2 = (List) anonymousClass12.L$4;
                                    FlowCollector flowCollector = (FlowCollector) anonymousClass12.L$3;
                                    Object obj = anonymousClass12.L$2;
                                    AnonymousClass1 anonymousClass13 = (AnonymousClass1) anonymousClass12.L$1;
                                    Object obj2 = anonymousClass12.L$0;
                                    ResultKt.throwOnFailure($result);
                                    break;
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1($completion);
                    anonymousClass12 = anonymousClass1;
                    Object $result2 = anonymousClass12.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (anonymousClass12.label) {
                    }
                    return Unit.INSTANCE;
                }
            }

            public Object collect(FlowCollector collector, Continuation $completion) {
                Object collect = $this$mapNotNull$iv.collect(new AnonymousClass2(collector), $completion);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        };
    }

    public final /* synthetic */ <T extends KCommandMsg.ICommand> Flow<T> ofCommandList() {
        Flow<List<KCommandMsg>> commandList = commandList();
        Intrinsics.needClassReification();
        return FlowKt.flatMapConcat(commandList, new IMBroadcastManager$ofCommandList$1(null));
    }
}