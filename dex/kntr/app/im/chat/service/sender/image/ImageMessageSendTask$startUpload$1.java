package kntr.app.im.chat.service.sender.image;

import androidx.compose.runtime.MutableState;
import com.bapis.bilibili.app.im.v1.KPictureModule;
import im.base.IMLog;
import kntr.app.im.chat.core.service.MessageSendProgress;
import kntr.app.im.chat.service.sender.image.ImageMessageSendTask$startUpload$1;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.paragraph.assetuploader.AssetUploader;
import kntr.common.paragraph.assetuploader.ImageUploadResult;
import kntr.common.paragraph.assetuploader.UploadTask;
import kntr.common.paragraph.assetuploader.base.AssetUploaderParams;
import kntr.common.photonic.ContentSize;
import kntr.common.photonic.MimeType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
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
import kotlin.ranges.RangesKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: ImageMessageSender.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/channels/ProducerScope;", "Lkntr/app/im/chat/core/service/MessageSendProgress;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.service.sender.image.ImageMessageSendTask$startUpload$1", f = "ImageMessageSender.kt", i = {0, 1, 2, 2}, l = {245, 248, 254}, m = "invokeSuspend", n = {"$this$channelFlow", "$this$channelFlow", "$this$channelFlow", "uploadTask"}, s = {"L$0", "L$0", "L$0", "L$1"}, v = 1)
final class ImageMessageSendTask$startUpload$1 extends SuspendLambda implements Function2<ProducerScope<? super MessageSendProgress>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ImageMessageSendTask this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageMessageSendTask$startUpload$1(ImageMessageSendTask imageMessageSendTask, Continuation<? super ImageMessageSendTask$startUpload$1> continuation) {
        super(2, continuation);
        this.this$0 = imageMessageSendTask;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> imageMessageSendTask$startUpload$1 = new ImageMessageSendTask$startUpload$1(this.this$0, continuation);
        imageMessageSendTask$startUpload$1.L$0 = obj;
        return imageMessageSendTask$startUpload$1;
    }

    public final Object invoke(ProducerScope<? super MessageSendProgress> producerScope, Continuation<? super Unit> continuation) {
        return create(producerScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00be A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object uploadAsset;
        UploadTask uploadTask;
        MutableState mutableState;
        ProducerScope $this$channelFlow = (ProducerScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z = true;
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.this$0.updateState(new MessageSendProgress.Uploading(0.0f));
                this.L$0 = $this$channelFlow;
                this.label = 1;
                if ($this$channelFlow.send(new MessageSendProgress.Uploading(0.0f), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                if (this.this$0.getCacheAsset() != null) {
                    AssetUploader assetUploader = this.this$0.getAssetUploader();
                    LocalImageAsset cacheAsset = this.this$0.getCacheAsset();
                    if (!Intrinsics.areEqual(this.this$0.getCacheAsset().getMimeType(), MimeType.Companion.getGIF()) && !this.this$0.getUseOriginImage()) {
                        z = false;
                    }
                    this.L$0 = $this$channelFlow;
                    this.label = 2;
                    uploadAsset = assetUploader.uploadAsset(cacheAsset, z, (AssetUploaderParams) null, (Continuation) this);
                    if (uploadAsset == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    uploadTask = (UploadTask) uploadAsset;
                    mutableState = this.this$0.snapshotTask;
                    mutableState.setValue(uploadTask);
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$channelFlow);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(uploadTask);
                    this.label = 3;
                    if (CoroutineScopeKt.coroutineScope(new AnonymousClass1(uploadTask, this.this$0, $this$channelFlow, null), (Continuation) this) != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                if (this.this$0.getCacheAsset() != null) {
                }
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure($result);
                uploadAsset = $result;
                uploadTask = (UploadTask) uploadAsset;
                mutableState = this.this$0.snapshotTask;
                mutableState.setValue(uploadTask);
                this.L$0 = SpillingKt.nullOutSpilledVariable($this$channelFlow);
                this.L$1 = SpillingKt.nullOutSpilledVariable(uploadTask);
                this.label = 3;
                if (CoroutineScopeKt.coroutineScope(new AnonymousClass1(uploadTask, this.this$0, $this$channelFlow, null), (Continuation) this) != coroutine_suspended) {
                }
                break;
            case 3:
                UploadTask uploadTask2 = (UploadTask) this.L$1;
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ImageMessageSender.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "kntr.app.im.chat.service.sender.image.ImageMessageSendTask$startUpload$1$1", f = "ImageMessageSender.kt", i = {0, 0, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3}, l = {272, 275, 286, 298}, m = "invokeSuspend", n = {"$this$coroutineScope", "uploadJob", "$this$coroutineScope", "uploadJob", "$this$coroutineScope", "uploadJob", "result", "imageModule", "$i$a$-onSuccess-ImageMessageSendTask$startUpload$1$1$5", "$this$coroutineScope", "uploadJob", "error", "failedState", "$i$a$-onFailure-ImageMessageSendTask$startUpload$1$1$6"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$3", "L$4", "I$0", "L$0", "L$1", "L$3", "L$4", "I$0"}, v = 1)
    /* renamed from: kntr.app.im.chat.service.sender.image.ImageMessageSendTask$startUpload$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ProducerScope<MessageSendProgress> $$this$channelFlow;
        final /* synthetic */ UploadTask $uploadTask;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        final /* synthetic */ ImageMessageSendTask this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(UploadTask uploadTask, ImageMessageSendTask imageMessageSendTask, ProducerScope<? super MessageSendProgress> producerScope, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$uploadTask = uploadTask;
            this.this$0 = imageMessageSendTask;
            this.$$this$channelFlow = producerScope;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$uploadTask, this.this$0, this.$$this$channelFlow, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x00d4 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:16:0x00d5  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x00e6  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x014b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object $result) {
            Deferred uploadJob;
            Object await;
            Deferred uploadJob2;
            Object obj;
            MutableState mutableState;
            Throwable error;
            Deferred uploadJob3;
            CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    uploadJob = BuildersKt.async$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ImageMessageSendTask$startUpload$1$1$uploadJob$1(this.$uploadTask, null), 3, (Object) null);
                    final Flow $this$map$iv = FlowKt.onEach(FlowKt.debounceDuration(this.$uploadTask.getProgress(), new Function1() { // from class: kntr.app.im.chat.service.sender.image.ImageMessageSendTask$startUpload$1$1$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj2) {
                            Duration invokeSuspend$lambda$0;
                            invokeSuspend$lambda$0 = ImageMessageSendTask$startUpload$1.AnonymousClass1.invokeSuspend$lambda$0((ContentSize) obj2);
                            return invokeSuspend$lambda$0;
                        }
                    }), new AnonymousClass2(this.this$0, this.$uploadTask, null));
                    final UploadTask uploadTask = this.$uploadTask;
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$coroutineScope);
                    this.L$1 = uploadJob;
                    this.label = 1;
                    if (FlowKt.collect(FlowKt.onEach(new Flow<MessageSendProgress.Uploading>() { // from class: kntr.app.im.chat.service.sender.image.ImageMessageSendTask$startUpload$1$1$invokeSuspend$$inlined$map$1
                        public Object collect(FlowCollector collector, Continuation $completion) {
                            Object collect = $this$map$iv.collect(new AnonymousClass2(collector, uploadTask), $completion);
                            return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                        }

                        /* compiled from: Emitters.kt */
                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
                        /* renamed from: kntr.app.im.chat.service.sender.image.ImageMessageSendTask$startUpload$1$1$invokeSuspend$$inlined$map$1$2  reason: invalid class name */
                        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                        public static final class AnonymousClass2<T> implements FlowCollector {
                            final /* synthetic */ FlowCollector $this_unsafeFlow;
                            final /* synthetic */ UploadTask $uploadTask$inlined;

                            /* compiled from: Emitters.kt */
                            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                            @DebugMetadata(c = "kntr.app.im.chat.service.sender.image.ImageMessageSendTask$startUpload$1$1$invokeSuspend$$inlined$map$1$2", f = "ImageMessageSender.kt", i = {0, 0, 0, 0, 0}, l = {219}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                            /* renamed from: kntr.app.im.chat.service.sender.image.ImageMessageSendTask$startUpload$1$1$invokeSuspend$$inlined$map$1$2$1  reason: invalid class name */
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

                            public AnonymousClass2(FlowCollector flowCollector, UploadTask uploadTask) {
                                this.$this_unsafeFlow = flowCollector;
                                this.$uploadTask$inlined = uploadTask;
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
                                                FlowCollector $this$map_u24lambda_u245 = this.$this_unsafeFlow;
                                                double it = ((ContentSize) value).unbox-impl();
                                                MessageSendProgress.Uploading uploading = new MessageSendProgress.Uploading(RangesKt.coerceIn((float) ContentSize.div-4yfSoQ8(it, this.$uploadTask$inlined.getTaskContentSize-QJZHGII()), 0.0f, 1.0f));
                                                $continuation.L$0 = SpillingKt.nullOutSpilledVariable(value);
                                                $continuation.L$1 = SpillingKt.nullOutSpilledVariable($continuation);
                                                $continuation.L$2 = SpillingKt.nullOutSpilledVariable(value);
                                                $continuation.L$3 = SpillingKt.nullOutSpilledVariable($this$map_u24lambda_u245);
                                                $continuation.I$0 = 0;
                                                $continuation.label = 1;
                                                if ($this$map_u24lambda_u245.emit(uploading, $continuation) != coroutine_suspended) {
                                                    break;
                                                } else {
                                                    return coroutine_suspended;
                                                }
                                            case 1:
                                                int i = $continuation.I$0;
                                                FlowCollector flowCollector = (FlowCollector) $continuation.L$3;
                                                Object obj = $continuation.L$2;
                                                AnonymousClass1 anonymousClass1 = (AnonymousClass1) $continuation.L$1;
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
                    }, new AnonymousClass4(this.this$0, this.$$this$channelFlow, null)), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$coroutineScope);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(uploadJob);
                    this.label = 2;
                    await = uploadJob.await((Continuation) this);
                    if (await != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    uploadJob2 = uploadJob;
                    obj = ((Result) await).unbox-impl();
                    ImageMessageSendTask imageMessageSendTask = this.this$0;
                    ProducerScope<MessageSendProgress> producerScope = this.$$this$channelFlow;
                    if (Result.isSuccess-impl(obj)) {
                        ImageUploadResult result = (ImageUploadResult) obj;
                        KPictureModule imageModule = new KPictureModule(result.getImageUrl(), (int) result.getImageWidth(), (int) result.getImageHeight(), (int) ContentSize.getBytes-impl(result.getImageSize-QJZHGII()));
                        mutableState = imageMessageSendTask.webImageModule;
                        mutableState.setValue(imageModule);
                        imageMessageSendTask.updateState(MessageSendProgress.ReadyToSend.INSTANCE);
                        MessageSendProgress.ReadyToSend readyToSend = MessageSendProgress.ReadyToSend.INSTANCE;
                        this.L$0 = SpillingKt.nullOutSpilledVariable($this$coroutineScope);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(uploadJob2);
                        this.L$2 = obj;
                        this.L$3 = SpillingKt.nullOutSpilledVariable(result);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(imageModule);
                        this.I$0 = 0;
                        this.label = 3;
                        if (producerScope.send(readyToSend, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    ImageMessageSendTask imageMessageSendTask2 = this.this$0;
                    ProducerScope<MessageSendProgress> producerScope2 = this.$$this$channelFlow;
                    error = Result.exceptionOrNull-impl(obj);
                    if (error != null) {
                        IMLog.Companion.e(ImageMessageSender.TAG, "Failed to upload image " + imageMessageSendTask2.getCacheAsset().getIdentifier(), error);
                        IllegalStateException illegalStateException = error instanceof Exception ? (Exception) error : null;
                        if (illegalStateException == null) {
                            illegalStateException = new IllegalStateException("Fail to send");
                        }
                        MessageSendProgress.SendFailed failedState = new MessageSendProgress.SendFailed(illegalStateException);
                        imageMessageSendTask2.updateState(failedState);
                        this.L$0 = SpillingKt.nullOutSpilledVariable($this$coroutineScope);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(uploadJob2);
                        this.L$2 = obj;
                        this.L$3 = SpillingKt.nullOutSpilledVariable(error);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(failedState);
                        this.I$0 = 0;
                        this.label = 4;
                        if (producerScope2.send(failedState, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        uploadJob3 = uploadJob2;
                    }
                    return Unit.INSTANCE;
                case 1:
                    uploadJob = (Deferred) this.L$1;
                    ResultKt.throwOnFailure($result);
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$coroutineScope);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(uploadJob);
                    this.label = 2;
                    await = uploadJob.await((Continuation) this);
                    if (await != coroutine_suspended) {
                    }
                    break;
                case 2:
                    ResultKt.throwOnFailure($result);
                    await = $result;
                    uploadJob2 = (Deferred) this.L$1;
                    obj = ((Result) await).unbox-impl();
                    ImageMessageSendTask imageMessageSendTask3 = this.this$0;
                    ProducerScope<MessageSendProgress> producerScope3 = this.$$this$channelFlow;
                    if (Result.isSuccess-impl(obj)) {
                    }
                    ImageMessageSendTask imageMessageSendTask22 = this.this$0;
                    ProducerScope<MessageSendProgress> producerScope22 = this.$$this$channelFlow;
                    error = Result.exceptionOrNull-impl(obj);
                    if (error != null) {
                    }
                    return Unit.INSTANCE;
                case 3:
                    int i = this.I$0;
                    KPictureModule kPictureModule = (KPictureModule) this.L$4;
                    ImageUploadResult imageUploadResult = (ImageUploadResult) this.L$3;
                    obj = this.L$2;
                    uploadJob2 = (Deferred) this.L$1;
                    ResultKt.throwOnFailure($result);
                    ImageMessageSendTask imageMessageSendTask222 = this.this$0;
                    ProducerScope<MessageSendProgress> producerScope222 = this.$$this$channelFlow;
                    error = Result.exceptionOrNull-impl(obj);
                    if (error != null) {
                    }
                    return Unit.INSTANCE;
                case 4:
                    int i2 = this.I$0;
                    MessageSendProgress.SendFailed sendFailed = (MessageSendProgress.SendFailed) this.L$4;
                    Throwable th = (Throwable) this.L$3;
                    uploadJob3 = (Deferred) this.L$1;
                    ResultKt.throwOnFailure($result);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ImageMessageSender.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "p", "Lkntr/common/photonic/ContentSize;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "kntr.app.im.chat.service.sender.image.ImageMessageSendTask$startUpload$1$1$2", f = "ImageMessageSender.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        /* renamed from: kntr.app.im.chat.service.sender.image.ImageMessageSendTask$startUpload$1$1$2  reason: invalid class name */
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<ContentSize, Continuation<? super Unit>, Object> {
            final /* synthetic */ UploadTask $uploadTask;
            /* synthetic */ double D$0;
            int label;
            final /* synthetic */ ImageMessageSendTask this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(ImageMessageSendTask imageMessageSendTask, UploadTask uploadTask, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = imageMessageSendTask;
                this.$uploadTask = uploadTask;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass2 = new AnonymousClass2(this.this$0, this.$uploadTask, continuation);
                anonymousClass2.D$0 = ((ContentSize) obj).unbox-impl();
                return anonymousClass2;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return m1594invokeJlC0FOg(((ContentSize) obj).unbox-impl(), (Continuation) obj2);
            }

            /* renamed from: invoke-JlC0FOg  reason: not valid java name */
            public final Object m1594invokeJlC0FOg(double d, Continuation<? super Unit> continuation) {
                return create(ContentSize.box-impl(d), continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object $result) {
                final double p = this.D$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        IMLog.Companion companion = IMLog.Companion;
                        final ImageMessageSendTask imageMessageSendTask = this.this$0;
                        final UploadTask uploadTask = this.$uploadTask;
                        companion.d(ImageMessageSender.TAG, new Function0() { // from class: kntr.app.im.chat.service.sender.image.ImageMessageSendTask$startUpload$1$1$2$$ExternalSyntheticLambda0
                            public final Object invoke() {
                                String invokeSuspend$lambda$0;
                                invokeSuspend$lambda$0 = ImageMessageSendTask$startUpload$1.AnonymousClass1.AnonymousClass2.invokeSuspend$lambda$0(ImageMessageSendTask.this, p, uploadTask);
                                return invokeSuspend$lambda$0;
                            }
                        });
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final String invokeSuspend$lambda$0(ImageMessageSendTask this$0, double $p, UploadTask $uploadTask) {
                String token = this$0.getToken();
                String identifier = this$0.getCacheAsset().getIdentifier();
                double d = ContentSize.getBytes-impl($p);
                return "Upload progress of task " + token + " file " + identifier + " " + d + "b / " + ContentSize.getBytes-impl($uploadTask.getTaskContentSize-QJZHGII()) + "b ";
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Duration invokeSuspend$lambda$0(ContentSize it) {
            Duration.Companion companion = Duration.Companion;
            return Duration.box-impl(DurationKt.toDuration(100, DurationUnit.MILLISECONDS));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ImageMessageSender.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "p", "Lkntr/app/im/chat/core/service/MessageSendProgress$Uploading;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "kntr.app.im.chat.service.sender.image.ImageMessageSendTask$startUpload$1$1$4", f = "ImageMessageSender.kt", i = {0}, l = {271}, m = "invokeSuspend", n = {"p"}, s = {"L$0"}, v = 1)
        /* renamed from: kntr.app.im.chat.service.sender.image.ImageMessageSendTask$startUpload$1$1$4  reason: invalid class name */
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class AnonymousClass4 extends SuspendLambda implements Function2<MessageSendProgress.Uploading, Continuation<? super Unit>, Object> {
            final /* synthetic */ ProducerScope<MessageSendProgress> $$this$channelFlow;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ ImageMessageSendTask this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass4(ImageMessageSendTask imageMessageSendTask, ProducerScope<? super MessageSendProgress> producerScope, Continuation<? super AnonymousClass4> continuation) {
                super(2, continuation);
                this.this$0 = imageMessageSendTask;
                this.$$this$channelFlow = producerScope;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass4 = new AnonymousClass4(this.this$0, this.$$this$channelFlow, continuation);
                anonymousClass4.L$0 = obj;
                return anonymousClass4;
            }

            public final Object invoke(MessageSendProgress.Uploading uploading, Continuation<? super Unit> continuation) {
                return create(uploading, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object $result) {
                MessageSendProgress.Uploading p = (MessageSendProgress.Uploading) this.L$0;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        this.this$0.updateState(p);
                        this.L$0 = SpillingKt.nullOutSpilledVariable(p);
                        this.label = 1;
                        if (this.$$this$channelFlow.send(p, (Continuation) this) == coroutine_suspended) {
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
    }
}