package kntr.app.im.chat.stateMachine.builder;

import androidx.compose.ui.unit.IntRect;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import im.base.IMLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kntr.app.im.chat.core.model.ChatAction;
import kntr.app.im.chat.core.model.ChatPageData;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.core.model.MessageGroup;
import kntr.app.im.chat.core.model.MsgModule;
import kntr.app.im.chat.module.PictureMsgModule;
import kntr.app.im.chat.module.localPicture.LocalPictureModule;
import kntr.app.im.chat.service.sender.image.LocalImageAsset;
import kntr.app.im.chat.service.sender.image.LocalImageAsset_androidKt;
import kntr.base.imageloader.ImageSource;
import kntr.common.photonic.aphro.ui.preview.model.PageImagePreviewType;
import kntr.common.photonic.aphro.ui.preview.model.PreviewImageData;
import kntr.common.photonic.aphro.ui.preview.model.WebImageAsset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImagePreview.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/im/chat/core/model/ChatPageData;", "action", "Lkntr/app/im/chat/core/model/ChatAction$ImagePreviewClicked;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.stateMachine.builder.ImagePreviewKt$bindImagePreview$1", f = "ImagePreview.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class ImagePreviewKt$bindImagePreview$1 extends SuspendLambda implements Function3<ChatAction.ImagePreviewClicked, State<ChatPageData>, Continuation<? super ChangedState<? extends ChatPageData>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImagePreviewKt$bindImagePreview$1(Continuation<? super ImagePreviewKt$bindImagePreview$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(ChatAction.ImagePreviewClicked imagePreviewClicked, State<ChatPageData> state, Continuation<? super ChangedState<ChatPageData>> continuation) {
        ImagePreviewKt$bindImagePreview$1 imagePreviewKt$bindImagePreview$1 = new ImagePreviewKt$bindImagePreview$1(continuation);
        imagePreviewKt$bindImagePreview$1.L$0 = imagePreviewClicked;
        imagePreviewKt$bindImagePreview$1.L$1 = state;
        return imagePreviewKt$bindImagePreview$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        boolean z;
        Iterator it;
        Object element$iv;
        LocalImageAsset asset;
        ChatAction.ImagePreviewClicked action = (ChatAction.ImagePreviewClicked) this.L$0;
        State state = (State) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                int assetIndex = 0;
                final Ref.ObjectRef initialAssetIndex = new Ref.ObjectRef();
                final List assets = new ArrayList();
                Iterable $this$flatMap$iv = ((ChatPageData) state.getSnapshot()).getMessageGroups();
                Collection destination$iv$iv = new ArrayList();
                for (Object element$iv$iv : $this$flatMap$iv) {
                    Iterable list$iv$iv = ((MessageGroup) element$iv$iv).getMessages();
                    CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
                }
                Iterable $this$forEach$iv = (List) destination$iv$iv;
                boolean z2 = false;
                Iterator it2 = $this$forEach$iv.iterator();
                while (it2.hasNext()) {
                    Object element$iv2 = it2.next();
                    EntityMessage it3 = (EntityMessage) element$iv2;
                    Iterable $this$forEachIndexed$iv = InitLoadKt.modules(it3);
                    int index$iv = 0;
                    for (Object item$iv : $this$forEachIndexed$iv) {
                        int index$iv2 = index$iv + 1;
                        if (index$iv < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        MsgModule module = (MsgModule) item$iv;
                        Iterable $this$forEach$iv2 = $this$forEach$iv;
                        if (module instanceof PictureMsgModule) {
                            z = z2;
                            if (!Intrinsics.areEqual(action.getMessage().getMsgId(), it3.getMsgId()) || index$iv != action.getIndex()) {
                                it = it2;
                                element$iv = element$iv2;
                                assets.add(InitLoadKt.from$default(WebImageAsset.Companion, ((PictureMsgModule) module).getValue(), null, null, 6, null));
                            } else {
                                initialAssetIndex.element = Boxing.boxInt(assetIndex);
                                it = it2;
                                element$iv = element$iv2;
                                assets.add(InitLoadKt.from(WebImageAsset.Companion, ((PictureMsgModule) module).getValue(), action.getFrameInWindow(), action.getImageSource()));
                            }
                            assetIndex++;
                        } else {
                            z = z2;
                            it = it2;
                            element$iv = element$iv2;
                            if ((module instanceof LocalPictureModule) && (asset = ((LocalPictureModule) module).getAsset()) != null) {
                                if (Intrinsics.areEqual(action.getMessage().getMsgId(), it3.getMsgId()) && index$iv == action.getIndex()) {
                                    initialAssetIndex.element = Boxing.boxInt(assetIndex);
                                    assets.add(new WebImageAsset(LocalImageAsset_androidKt.imagePathForDisplay(((LocalPictureModule) module).getAsset()), asset.m1599getContentSizeQJZHGII(), asset.getCreateTime(), asset.getModifyTime(), asset.getResolution(), asset.getOrientation(), asset.getMimeType(), action.getFrameInWindow(), action.getImageSource(), (DefaultConstructorMarker) null));
                                } else {
                                    assets.add(new WebImageAsset(LocalImageAsset_androidKt.imagePathForDisplay(((LocalPictureModule) module).getAsset()), asset.m1599getContentSizeQJZHGII(), asset.getCreateTime(), asset.getModifyTime(), asset.getResolution(), asset.getOrientation(), asset.getMimeType(), (IntRect) null, (ImageSource) null, (DefaultConstructorMarker) null));
                                }
                                assetIndex++;
                            }
                        }
                        index$iv = index$iv2;
                        $this$forEach$iv = $this$forEach$iv2;
                        z2 = z;
                        it2 = it;
                        element$iv2 = element$iv;
                    }
                }
                if (initialAssetIndex.element == null) {
                    IMLog.Companion.w("ImagePreview", "Cannot find initial image in message modules " + action.getMessage().getMsgId() + " with index " + action.getIndex());
                    return state.noChange();
                }
                return state.mutate(new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.ImagePreviewKt$bindImagePreview$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        ChatPageData invokeSuspend$lambda$2;
                        invokeSuspend$lambda$2 = ImagePreviewKt$bindImagePreview$1.invokeSuspend$lambda$2(assets, initialAssetIndex, (ChatPageData) obj);
                        return invokeSuspend$lambda$2;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChatPageData invokeSuspend$lambda$2(List $assets, Ref.ObjectRef $initialAssetIndex, ChatPageData $this$mutate) {
        ChatPageData copy;
        copy = $this$mutate.copy((r36 & 1) != 0 ? $this$mutate.sessionId : null, (r36 & 2) != 0 ? $this$mutate.hostMid : 0L, (r36 & 4) != 0 ? $this$mutate.pageStatus : null, (r36 & 8) != 0 ? $this$mutate.chatInfo : null, (r36 & 16) != 0 ? $this$mutate.messageGroups : null, (r36 & 32) != 0 ? $this$mutate.toast : null, (r36 & 64) != 0 ? $this$mutate.previewImageData : new PreviewImageData($assets, PageImagePreviewType.DEFAULT_IMAGE, ((Number) $initialAssetIndex.element).intValue(), (String) null, (String) null, 24, (DefaultConstructorMarker) null), (r36 & 128) != 0 ? $this$mutate.isShowStickerEditPage : false, (r36 & 256) != 0 ? $this$mutate.route : null, (r36 & 512) != 0 ? $this$mutate.upgradeAnswerDialogStatus : null, (r36 & 1024) != 0 ? $this$mutate.pendingMsgForUpdate : null, (r36 & 2048) != 0 ? $this$mutate.inputBoxSelectState : null, (r36 & 4096) != 0 ? $this$mutate.deletingMsg : null, (r36 & 8192) != 0 ? $this$mutate.displayingBehaviorAlert : null, (r36 & 16384) != 0 ? $this$mutate.currentFetchResult : null, (r36 & 32768) != 0 ? $this$mutate.inputContent : null, (r36 & 65536) != 0 ? $this$mutate.track : null);
        return copy;
    }
}