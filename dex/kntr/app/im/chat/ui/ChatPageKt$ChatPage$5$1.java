package kntr.app.im.chat.ui;

import android.app.Activity;
import im.base.IMLog;
import java.util.List;
import kntr.app.im.chat.core.model.ChatAction;
import kntr.app.im.chat.core.model.ChatPageData;
import kntr.app.im.chat.stateMachine.builder.DispatchAphroAction;
import kntr.app.im.chat.ui.utils.PictureLifecycleKeyHandle;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.router.Router;
import kntr.common.photonic.Asset;
import kntr.common.photonic.aphro.core.AphroAction;
import kntr.common.photonic.aphro.core.AphroSelectOption;
import kntr.common.photonic.aphro.core.AspectRadioLimit;
import kntr.common.photonic.aphro.core.ContentSizeLimit;
import kntr.common.photonic.aphro.ui.preview.ImagePreviewLauncher_androidKt;
import kntr.common.photonic.aphro.ui.preview.ImagePreviewType;
import kntr.common.photonic.aphro.ui.preview.model.ImagePreviewDataNotifier;
import kntr.common.photonic.aphro.ui.preview.model.ImagePreviewSelectResult;
import kntr.common.photonic.aphro.ui.preview.model.PageImagePreviewType;
import kntr.common.photonic.aphro.ui.preview.model.PreviewImageData;
import kntr.common.photonic.gallery.GalleryLoadConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: ChatPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.ui.ChatPageKt$ChatPage$5$1", f = "ChatPage.kt", i = {0, 0, 1, 1, 2, 2}, l = {212, 237, 244}, m = "invokeSuspend", n = {"$this$LaunchedEffect", "previewImageData", "$this$LaunchedEffect", "previewImageData", "$this$LaunchedEffect", "previewImageData"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1"}, v = 1)
final class ChatPageKt$ChatPage$5$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ChatActionHandler $actionHandler;
    final /* synthetic */ Activity $context;
    final /* synthetic */ ChatPageData $pageData;
    final /* synthetic */ PictureLifecycleKeyHandle $pictureLifecycleKeyHandle;
    final /* synthetic */ Router $router;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* compiled from: ChatPage.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PageImagePreviewType.values().length];
            try {
                iArr[PageImagePreviewType.GALLERY_IMAGE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[PageImagePreviewType.DEFAULT_IMAGE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatPageKt$ChatPage$5$1(ChatPageData chatPageData, Router router, Activity activity, PictureLifecycleKeyHandle pictureLifecycleKeyHandle, ChatActionHandler chatActionHandler, Continuation<? super ChatPageKt$ChatPage$5$1> continuation) {
        super(2, continuation);
        this.$pageData = chatPageData;
        this.$router = router;
        this.$context = activity;
        this.$pictureLifecycleKeyHandle = pictureLifecycleKeyHandle;
        this.$actionHandler = chatActionHandler;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> chatPageKt$ChatPage$5$1 = new ChatPageKt$ChatPage$5$1(this.$pageData, this.$router, this.$context, this.$pictureLifecycleKeyHandle, this.$actionHandler, continuation);
        chatPageKt$ChatPage$5$1.L$0 = obj;
        return chatPageKt$ChatPage$5$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00ab A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        PreviewImageData previewImageData;
        PreviewImageData previewImageData2;
        CoroutineScope $this$LaunchedEffect = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                PreviewImageData previewImageData3 = this.$pageData.getPreviewImageData();
                PageImagePreviewType currentPreviewType = previewImageData3 != null ? previewImageData3.getCurrentPreviewType() : null;
                switch (currentPreviewType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[currentPreviewType.ordinal()]) {
                    case 1:
                        BuildersKt.launch$default($this$LaunchedEffect, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(previewImageData3, this.$actionHandler, null), 3, (Object) null);
                        Router router = this.$router;
                        List currentPreviewDataSource = previewImageData3.getCurrentPreviewDataSource();
                        int currentPreviewInitialIndex = previewImageData3.getCurrentPreviewInitialIndex();
                        List<Asset> selectedAssets = this.$pageData.getInputContent().getSelectedAssets();
                        boolean useOriginImage = this.$pageData.getInputContent().getUseOriginImage();
                        String selectResultMatchKey = previewImageData3.getSelectResultMatchKey();
                        this.L$0 = SpillingKt.nullOutSpilledVariable($this$LaunchedEffect);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(previewImageData3);
                        this.label = 1;
                        if (ImagePreviewLauncher_androidKt.launchImagePreview(router, currentPreviewDataSource, currentPreviewInitialIndex, new ImagePreviewType.Gallery(selectedAssets, useOriginImage, new AphroSelectOption(9, 0, false, (GalleryLoadConfig) null, (List) null, false, false, false, (ContentSizeLimit) null, (AspectRadioLimit) null, 1022, (DefaultConstructorMarker) null), selectResultMatchKey), this.$context, previewImageData3.getCurrentSelectAlbumId(), (Continuation) this) != coroutine_suspended) {
                            previewImageData = previewImageData3;
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 2:
                        this.$pictureLifecycleKeyHandle.trigger(false);
                        this.L$0 = SpillingKt.nullOutSpilledVariable($this$LaunchedEffect);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(previewImageData3);
                        this.label = 2;
                        if (ImagePreviewLauncher_androidKt.launchImagePreview$default(this.$router, previewImageData3.getCurrentPreviewDataSource(), previewImageData3.getCurrentPreviewInitialIndex(), ImagePreviewType.Default.INSTANCE, this.$context, (String) null, (Continuation) this, 32, (Object) null) != coroutine_suspended) {
                            previewImageData2 = previewImageData3;
                            this.L$0 = SpillingKt.nullOutSpilledVariable($this$LaunchedEffect);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(previewImageData2);
                            this.label = 3;
                            if (this.$actionHandler.invoke(ChatAction.ImagePreviewClosed.INSTANCE, (Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            this.$pictureLifecycleKeyHandle.trigger(true);
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                }
                return Unit.INSTANCE;
            case 1:
                previewImageData = (PreviewImageData) this.L$1;
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            case 2:
                previewImageData2 = (PreviewImageData) this.L$1;
                ResultKt.throwOnFailure($result);
                this.L$0 = SpillingKt.nullOutSpilledVariable($this$LaunchedEffect);
                this.L$1 = SpillingKt.nullOutSpilledVariable(previewImageData2);
                this.label = 3;
                if (this.$actionHandler.invoke(ChatAction.ImagePreviewClosed.INSTANCE, (Continuation) this) == coroutine_suspended) {
                }
                this.$pictureLifecycleKeyHandle.trigger(true);
                return Unit.INSTANCE;
            case 3:
                previewImageData2 = (PreviewImageData) this.L$1;
                ResultKt.throwOnFailure($result);
                this.$pictureLifecycleKeyHandle.trigger(true);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ChatPage.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "kntr.app.im.chat.ui.ChatPageKt$ChatPage$5$1$1", f = "ChatPage.kt", i = {}, l = {192, 208}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: kntr.app.im.chat.ui.ChatPageKt$ChatPage$5$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ChatActionHandler $actionHandler;
        final /* synthetic */ PreviewImageData $previewImageData;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(PreviewImageData previewImageData, ChatActionHandler chatActionHandler, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$previewImageData = previewImageData;
            this.$actionHandler = chatActionHandler;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$previewImageData, this.$actionHandler, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0062 A[RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (FlowKt.onEach(FlowKt.receiveAsFlow(ImagePreviewDataNotifier.INSTANCE.getPreviewSelectResultChannel(this.$previewImageData.getSelectResultMatchKey())), new C00201(null)).collect(new AnonymousClass2(this.$actionHandler), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    this.label = 2;
                    if (this.$actionHandler.invoke(ChatAction.ImagePreviewClosed.INSTANCE, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                case 1:
                    ResultKt.throwOnFailure($result);
                    this.label = 2;
                    if (this.$actionHandler.invoke(ChatAction.ImagePreviewClosed.INSTANCE, (Continuation) this) == coroutine_suspended) {
                    }
                    return Unit.INSTANCE;
                case 2:
                    ResultKt.throwOnFailure($result);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ChatPage.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "it", "Lkntr/common/photonic/aphro/ui/preview/model/ImagePreviewSelectResult;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "kntr.app.im.chat.ui.ChatPageKt$ChatPage$5$1$1$1", f = "ChatPage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        /* renamed from: kntr.app.im.chat.ui.ChatPageKt$ChatPage$5$1$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class C00201 extends SuspendLambda implements Function2<ImagePreviewSelectResult, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;

            C00201(Continuation<? super C00201> continuation) {
                super(2, continuation);
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> c00201 = new C00201(continuation);
                c00201.L$0 = obj;
                return c00201;
            }

            public final Object invoke(ImagePreviewSelectResult imagePreviewSelectResult, Continuation<? super Unit> continuation) {
                return create(imagePreviewSelectResult, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object $result) {
                ImagePreviewSelectResult it = (ImagePreviewSelectResult) this.L$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        IMLog.Companion.i("ChatPage", "selected image: " + it);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ChatPage.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* renamed from: kntr.app.im.chat.ui.ChatPageKt$ChatPage$5$1$1$2  reason: invalid class name */
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class AnonymousClass2<T> implements FlowCollector {
            final /* synthetic */ ChatActionHandler $actionHandler;

            AnonymousClass2(ChatActionHandler chatActionHandler) {
                this.$actionHandler = chatActionHandler;
            }

            public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                return emit((ImagePreviewSelectResult) value, (Continuation<? super Unit>) $completion);
            }

            /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
            /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
            /* JADX WARN: Removed duplicated region for block: B:13:0x0035  */
            /* JADX WARN: Removed duplicated region for block: B:14:0x003e  */
            /* JADX WARN: Removed duplicated region for block: B:19:0x0084 A[RETURN] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object emit(ImagePreviewSelectResult it, Continuation<? super Unit> continuation) {
                ChatPageKt$ChatPage$5$1$1$2$emit$1 chatPageKt$ChatPage$5$1$1$2$emit$1;
                if (continuation instanceof ChatPageKt$ChatPage$5$1$1$2$emit$1) {
                    chatPageKt$ChatPage$5$1$1$2$emit$1 = (ChatPageKt$ChatPage$5$1$1$2$emit$1) continuation;
                    if ((chatPageKt$ChatPage$5$1$1$2$emit$1.label & Integer.MIN_VALUE) != 0) {
                        chatPageKt$ChatPage$5$1$1$2$emit$1.label -= Integer.MIN_VALUE;
                        Object $result = chatPageKt$ChatPage$5$1$1$2$emit$1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (chatPageKt$ChatPage$5$1$1$2$emit$1.label) {
                            case 0:
                                ResultKt.throwOnFailure($result);
                                chatPageKt$ChatPage$5$1$1$2$emit$1.L$0 = it;
                                chatPageKt$ChatPage$5$1$1$2$emit$1.label = 1;
                                if (this.$actionHandler.invoke(new DispatchAphroAction(new AphroAction.SetSelectedAssets(it.getSelectedAssets())), chatPageKt$ChatPage$5$1$1$2$emit$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                chatPageKt$ChatPage$5$1$1$2$emit$1.L$0 = SpillingKt.nullOutSpilledVariable(it);
                                chatPageKt$ChatPage$5$1$1$2$emit$1.label = 2;
                                if (this.$actionHandler.invoke(new DispatchAphroAction(new AphroAction.CheckUseOriginImage(it.getUseOriginImage())), chatPageKt$ChatPage$5$1$1$2$emit$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                return Unit.INSTANCE;
                            case 1:
                                it = (ImagePreviewSelectResult) chatPageKt$ChatPage$5$1$1$2$emit$1.L$0;
                                ResultKt.throwOnFailure($result);
                                chatPageKt$ChatPage$5$1$1$2$emit$1.L$0 = SpillingKt.nullOutSpilledVariable(it);
                                chatPageKt$ChatPage$5$1$1$2$emit$1.label = 2;
                                if (this.$actionHandler.invoke(new DispatchAphroAction(new AphroAction.CheckUseOriginImage(it.getUseOriginImage())), chatPageKt$ChatPage$5$1$1$2$emit$1) == coroutine_suspended) {
                                }
                                return Unit.INSTANCE;
                            case 2:
                                ImagePreviewSelectResult imagePreviewSelectResult = (ImagePreviewSelectResult) chatPageKt$ChatPage$5$1$1$2$emit$1.L$0;
                                ResultKt.throwOnFailure($result);
                                return Unit.INSTANCE;
                            default:
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    }
                }
                chatPageKt$ChatPage$5$1$1$2$emit$1 = new ChatPageKt$ChatPage$5$1$1$2$emit$1(this, continuation);
                Object $result2 = chatPageKt$ChatPage$5$1$1$2$emit$1.result;
                Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (chatPageKt$ChatPage$5$1$1$2$emit$1.label) {
                }
            }
        }
    }
}