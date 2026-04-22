package kntr.app.im.chat.service.sender.image;

import com.bapis.bilibili.app.im.v1.KEntityMsgType;
import com.bapis.bilibili.app.im.v1.KUserPlaceholder;
import kntr.app.im.chat.core.model.InputContent;
import kntr.app.im.chat.core.service.MessageSendProgress;
import kntr.app.im.chat.core.service.NetworkSendMessageService;
import kntr.app.im.chat.network.MsgModuleTransformers;
import kntr.common.paragraph.assetuploader.AssetUploader;
import kntr.common.photonic.Asset;
import kntr.common.photonic.Orientation;
import kntr.common.photonic.Resolution;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.uuid.Uuid;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImageMessageSender.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lkntr/app/im/chat/service/sender/image/ImageMessageSendTask;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.service.sender.image.ImageMessageSender$send$2$2$1", f = "ImageMessageSender.kt", i = {}, l = {71}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class ImageMessageSender$send$2$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ImageMessageSendTask>, Object> {
    final /* synthetic */ Asset $asset;
    final /* synthetic */ InputContent $content;
    final /* synthetic */ KEntityMsgType $msgType;
    final /* synthetic */ long $offset;
    final /* synthetic */ KUserPlaceholder $userPlaceholder;
    int label;
    final /* synthetic */ ImageMessageSender this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageMessageSender$send$2$2$1(ImageMessageSender imageMessageSender, Asset asset, InputContent inputContent, KEntityMsgType kEntityMsgType, long j2, KUserPlaceholder kUserPlaceholder, Continuation<? super ImageMessageSender$send$2$2$1> continuation) {
        super(2, continuation);
        this.this$0 = imageMessageSender;
        this.$asset = asset;
        this.$content = inputContent;
        this.$msgType = kEntityMsgType;
        this.$offset = j2;
        this.$userPlaceholder = kUserPlaceholder;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ImageMessageSender$send$2$2$1(this.this$0, this.$asset, this.$content, this.$msgType, this.$offset, this.$userPlaceholder, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ImageMessageSendTask> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        AssetCopier assetCopier;
        Object copyToCache;
        NetworkSendMessageService networkSendMessageService;
        AssetUploader assetUploader;
        MsgModuleTransformers msgModuleTransformers;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                assetCopier = this.this$0.copier;
                this.label = 1;
                copyToCache = assetCopier.copyToCache(this.$asset, (Continuation) this);
                if (copyToCache == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                copyToCache = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        LocalImageAsset cacheAsset = (LocalImageAsset) copyToCache;
        networkSendMessageService = this.this$0.networkSendMessageService;
        String uuid = Uuid.Companion.random().toString();
        boolean useOriginImage = this.$content.getUseOriginImage();
        assetUploader = this.this$0.assetUploader;
        msgModuleTransformers = this.this$0.transformers;
        return new ImageMessageSendTask(networkSendMessageService, assetUploader, this.$msgType, uuid, this.$offset, cacheAsset, this.$userPlaceholder, useOriginImage, msgModuleTransformers, (MessageSendProgress) null, (Resolution) null, (Orientation) null, 3584, (DefaultConstructorMarker) null);
    }
}