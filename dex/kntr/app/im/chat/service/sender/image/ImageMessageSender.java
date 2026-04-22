package kntr.app.im.chat.service.sender.image;

import com.bapis.bilibili.app.im.v1.KEntityMsgType;
import com.bapis.bilibili.app.im.v1.KUserPlaceholder;
import im.base.model.SessionId;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.core.model.InputContent;
import kntr.app.im.chat.core.model.MsgModule;
import kntr.app.im.chat.core.service.MessageSendProgress;
import kntr.app.im.chat.core.service.MessageTask;
import kntr.app.im.chat.core.service.NetworkSendMessageService;
import kntr.app.im.chat.module.PictureMsgModule;
import kntr.app.im.chat.module.localPicture.LocalPictureModule;
import kntr.app.im.chat.network.MsgModuleTransformers;
import kntr.app.im.chat.service.sender.MessageSender;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.paragraph.assetuploader.AssetUploader;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.uuid.Uuid;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: ImageMessageSender.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJB\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0096@¢\u0006\u0002\u0010\u001aJ.\u0010\u001b\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0096@¢\u0006\u0002\u0010\u001eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lkntr/app/im/chat/service/sender/image/ImageMessageSender;", "Lkntr/app/im/chat/service/sender/MessageSender;", "assetUploader", "Lkntr/common/paragraph/assetuploader/AssetUploader;", "transformers", "Lkntr/app/im/chat/network/MsgModuleTransformers;", "copier", "Lkntr/app/im/chat/service/sender/image/AssetCopier;", "networkSendMessageService", "Lkntr/app/im/chat/core/service/NetworkSendMessageService;", "<init>", "(Lkntr/common/paragraph/assetuploader/AssetUploader;Lkntr/app/im/chat/network/MsgModuleTransformers;Lkntr/app/im/chat/service/sender/image/AssetCopier;Lkntr/app/im/chat/core/service/NetworkSendMessageService;)V", "send", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/core/service/MessageTask;", "sessionId", "Lim/base/model/SessionId;", "content", "Lkntr/app/im/chat/core/model/InputContent;", "msgType", "Lcom/bapis/bilibili/app/im/v1/KEntityMsgType;", "userPlaceholder", "Lcom/bapis/bilibili/app/im/v1/KUserPlaceholder;", "offsetProvider", "Lkotlin/Function0;", RoomRecommendViewModel.EMPTY_CURSOR, "(Lim/base/model/SessionId;Lkntr/app/im/chat/core/model/InputContent;Lcom/bapis/bilibili/app/im/v1/KEntityMsgType;Lcom/bapis/bilibili/app/im/v1/KUserPlaceholder;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resend", "message", "Lkntr/app/im/chat/core/model/EntityMessage;", "(Lkntr/app/im/chat/core/model/EntityMessage;Lcom/bapis/bilibili/app/im/v1/KUserPlaceholder;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ImageMessageSender implements MessageSender {
    public static final String TAG = "ImageMessageSender";
    private final AssetUploader assetUploader;
    private final AssetCopier copier;
    private final NetworkSendMessageService networkSendMessageService;
    private final MsgModuleTransformers transformers;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    @Inject
    public ImageMessageSender(AssetUploader assetUploader, MsgModuleTransformers transformers, AssetCopier copier, NetworkSendMessageService networkSendMessageService) {
        Intrinsics.checkNotNullParameter(assetUploader, "assetUploader");
        Intrinsics.checkNotNullParameter(transformers, "transformers");
        Intrinsics.checkNotNullParameter(copier, "copier");
        Intrinsics.checkNotNullParameter(networkSendMessageService, "networkSendMessageService");
        this.assetUploader = assetUploader;
        this.transformers = transformers;
        this.copier = copier;
        this.networkSendMessageService = networkSendMessageService;
    }

    /* compiled from: ImageMessageSender.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lkntr/app/im/chat/service/sender/image/ImageMessageSender$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "TAG", RoomRecommendViewModel.EMPTY_CURSOR, "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00d1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    @Override // kntr.app.im.chat.service.sender.MessageSender
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object send(SessionId sessionId, InputContent content, KEntityMsgType msgType, KUserPlaceholder userPlaceholder, Function0<Long> function0, Continuation<? super List<? extends MessageTask>> continuation) {
        ImageMessageSender$send$1 imageMessageSender$send$1;
        SessionId sessionId2;
        InputContent content2;
        KEntityMsgType msgType2;
        KUserPlaceholder userPlaceholder2;
        Object obj;
        Function0 offsetProvider;
        if (continuation instanceof ImageMessageSender$send$1) {
            imageMessageSender$send$1 = (ImageMessageSender$send$1) continuation;
            if ((imageMessageSender$send$1.label & Integer.MIN_VALUE) != 0) {
                imageMessageSender$send$1.label -= Integer.MIN_VALUE;
                Object $result = imageMessageSender$send$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (imageMessageSender$send$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        imageMessageSender$send$1.L$0 = SpillingKt.nullOutSpilledVariable(sessionId);
                        imageMessageSender$send$1.L$1 = SpillingKt.nullOutSpilledVariable(content);
                        imageMessageSender$send$1.L$2 = SpillingKt.nullOutSpilledVariable(msgType);
                        imageMessageSender$send$1.L$3 = SpillingKt.nullOutSpilledVariable(userPlaceholder);
                        imageMessageSender$send$1.L$4 = SpillingKt.nullOutSpilledVariable(function0);
                        imageMessageSender$send$1.label = 1;
                        Object coroutineScope = CoroutineScopeKt.coroutineScope(new ImageMessageSender$send$2(content, function0, this, msgType, userPlaceholder, null), imageMessageSender$send$1);
                        if (coroutineScope != coroutine_suspended) {
                            sessionId2 = sessionId;
                            content2 = content;
                            msgType2 = msgType;
                            userPlaceholder2 = userPlaceholder;
                            obj = coroutineScope;
                            offsetProvider = function0;
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        offsetProvider = (Function0) imageMessageSender$send$1.L$4;
                        userPlaceholder2 = (KUserPlaceholder) imageMessageSender$send$1.L$3;
                        msgType2 = (KEntityMsgType) imageMessageSender$send$1.L$2;
                        content2 = (InputContent) imageMessageSender$send$1.L$1;
                        sessionId2 = (SessionId) imageMessageSender$send$1.L$0;
                        ResultKt.throwOnFailure($result);
                        obj = $result;
                        break;
                    case 2:
                        Function0 function02 = (Function0) imageMessageSender$send$1.L$4;
                        KUserPlaceholder kUserPlaceholder = (KUserPlaceholder) imageMessageSender$send$1.L$3;
                        KEntityMsgType kEntityMsgType = (KEntityMsgType) imageMessageSender$send$1.L$2;
                        InputContent inputContent = (InputContent) imageMessageSender$send$1.L$1;
                        SessionId sessionId3 = (SessionId) imageMessageSender$send$1.L$0;
                        ResultKt.throwOnFailure($result);
                        return $result;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                imageMessageSender$send$1.L$0 = SpillingKt.nullOutSpilledVariable(sessionId2);
                imageMessageSender$send$1.L$1 = SpillingKt.nullOutSpilledVariable(content2);
                imageMessageSender$send$1.L$2 = SpillingKt.nullOutSpilledVariable(msgType2);
                imageMessageSender$send$1.L$3 = SpillingKt.nullOutSpilledVariable(userPlaceholder2);
                imageMessageSender$send$1.L$4 = SpillingKt.nullOutSpilledVariable(offsetProvider);
                imageMessageSender$send$1.label = 2;
                Object awaitAll = AwaitKt.awaitAll((Collection) obj, imageMessageSender$send$1);
                return awaitAll != coroutine_suspended ? coroutine_suspended : awaitAll;
            }
        }
        imageMessageSender$send$1 = new ImageMessageSender$send$1(this, continuation);
        Object $result2 = imageMessageSender$send$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (imageMessageSender$send$1.label) {
        }
        imageMessageSender$send$1.L$0 = SpillingKt.nullOutSpilledVariable(sessionId2);
        imageMessageSender$send$1.L$1 = SpillingKt.nullOutSpilledVariable(content2);
        imageMessageSender$send$1.L$2 = SpillingKt.nullOutSpilledVariable(msgType2);
        imageMessageSender$send$1.L$3 = SpillingKt.nullOutSpilledVariable(userPlaceholder2);
        imageMessageSender$send$1.L$4 = SpillingKt.nullOutSpilledVariable(offsetProvider);
        imageMessageSender$send$1.label = 2;
        Object awaitAll2 = AwaitKt.awaitAll((Collection) obj, imageMessageSender$send$1);
        if (awaitAll2 != coroutine_suspended2) {
        }
    }

    @Override // kntr.app.im.chat.service.sender.MessageSender
    public Object resend(EntityMessage message, KUserPlaceholder userPlaceholder, Function0<Long> function0, Continuation<? super MessageTask> continuation) {
        MsgModule imgModule = (MsgModule) CollectionsKt.single(message.getMsgFrame().getModules());
        if (imgModule instanceof LocalPictureModule) {
            LocalImageAsset asset = ((LocalPictureModule) imgModule).getAsset();
            if (asset == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            NetworkSendMessageService networkSendMessageService = this.networkSendMessageService;
            KEntityMsgType msgType = message.getMsgType();
            String token = message.getToken();
            if (token == null) {
                token = Uuid.Companion.random().toString();
            }
            return new ImageMessageSendTask(networkSendMessageService, this.assetUploader, msgType, token, ((Number) function0.invoke()).longValue(), asset, userPlaceholder, ((LocalPictureModule) imgModule).getUseOriginImage(), this.transformers, (MessageSendProgress) null, ((LocalPictureModule) imgModule).getResolution(), ((LocalPictureModule) imgModule).getOrientation(), 512, (DefaultConstructorMarker) null);
        } else if (imgModule instanceof PictureMsgModule) {
            NetworkSendMessageService networkSendMessageService2 = this.networkSendMessageService;
            AssetUploader assetUploader = this.assetUploader;
            MsgModuleTransformers msgModuleTransformers = this.transformers;
            KEntityMsgType msgType2 = message.getMsgType();
            String token2 = message.getToken();
            if (token2 == null) {
                token2 = Uuid.Companion.random().toString();
            }
            return new ImageMessageSendTask(networkSendMessageService2, null, assetUploader, false, userPlaceholder, msgModuleTransformers, null, null, msgType2, token2, ((Number) function0.invoke()).longValue(), MessageSendProgress.ReadyToSend.INSTANCE, ((PictureMsgModule) imgModule).getValue(), null, 192, null);
        } else {
            return null;
        }
    }
}