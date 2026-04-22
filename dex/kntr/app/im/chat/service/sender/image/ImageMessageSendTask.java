package kntr.app.im.chat.service.sender.image;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import com.bapis.bilibili.app.im.v1.KBubbleStyle;
import com.bapis.bilibili.app.im.v1.KChatBubbleFrame;
import com.bapis.bilibili.app.im.v1.KChatBubbleWidget;
import com.bapis.bilibili.app.im.v1.KEntityMsgType;
import com.bapis.bilibili.app.im.v1.KMsgModule;
import com.bapis.bilibili.app.im.v1.KPictureModule;
import com.bapis.bilibili.app.im.v1.KTalkerInfo;
import com.bapis.bilibili.app.im.v1.KUserPlaceholder;
import im.base.IMLog;
import java.util.List;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.core.model.MsgFrame;
import kntr.app.im.chat.core.service.MessageSendProgress;
import kntr.app.im.chat.core.service.MessageTask;
import kntr.app.im.chat.core.service.NetworkSendMessageService;
import kntr.app.im.chat.frame.bubble.ChatBubbleFrame;
import kntr.app.im.chat.module.localPicture.LocalPictureModule;
import kntr.app.im.chat.network.MsgModuleTransformers;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.paragraph.assetuploader.AssetUploader;
import kntr.common.paragraph.assetuploader.UploadTask;
import kntr.common.photonic.Orientation;
import kntr.common.photonic.Resolution;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.uuid.Uuid;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.datetime.Clock;

/* compiled from: ImageMessageSender.kt */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u008d\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u001e\u0010\u001fBs\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u001e\u0010 J\u000e\u0010B\u001a\u00020?H\u0096@¢\u0006\u0002\u0010CJ\u000e\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00190EH\u0016J\u0016\u0010F\u001a\b\u0012\u0004\u0012\u00020H0GH\u0096@¢\u0006\u0004\bI\u0010CJ\u0010\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020\u0019H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0014\u0010\u0012\u001a\u00020\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0014\u0010\u0014\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0014\u0010\u0016\u001a\u00020\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010706X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00108\u001a\b\u0012\u0004\u0012\u00020\u001906X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00109\u001a\b\u0012\u0004\u0012\u00020\u00190:8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<R\u0016\u0010=\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b06X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010>\u001a\u00020?8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b@\u0010A¨\u0006M"}, d2 = {"Lkntr/app/im/chat/service/sender/image/ImageMessageSendTask;", "Lkntr/app/im/chat/core/service/MessageTask;", "networkSendMessageService", "Lkntr/app/im/chat/core/service/NetworkSendMessageService;", "cacheAsset", "Lkntr/app/im/chat/service/sender/image/LocalImageAsset;", "assetUploader", "Lkntr/common/paragraph/assetuploader/AssetUploader;", "useOriginImage", RoomRecommendViewModel.EMPTY_CURSOR, "userPlaceholder", "Lcom/bapis/bilibili/app/im/v1/KUserPlaceholder;", "transformers", "Lkntr/app/im/chat/network/MsgModuleTransformers;", "resolution", "Lkntr/common/photonic/Resolution;", "orientation", "Lkntr/common/photonic/Orientation;", "msgType", "Lcom/bapis/bilibili/app/im/v1/KEntityMsgType;", "token", RoomRecommendViewModel.EMPTY_CURSOR, "sequenceOffset", RoomRecommendViewModel.EMPTY_CURSOR, "initState", "Lkntr/app/im/chat/core/service/MessageSendProgress;", "webImage", "Lcom/bapis/bilibili/app/im/v1/KPictureModule;", "localPictureModule", "Lkntr/app/im/chat/module/localPicture/LocalPictureModule;", "<init>", "(Lkntr/app/im/chat/core/service/NetworkSendMessageService;Lkntr/app/im/chat/service/sender/image/LocalImageAsset;Lkntr/common/paragraph/assetuploader/AssetUploader;ZLcom/bapis/bilibili/app/im/v1/KUserPlaceholder;Lkntr/app/im/chat/network/MsgModuleTransformers;Lkntr/common/photonic/Resolution;Lkntr/common/photonic/Orientation;Lcom/bapis/bilibili/app/im/v1/KEntityMsgType;Ljava/lang/String;JLkntr/app/im/chat/core/service/MessageSendProgress;Lcom/bapis/bilibili/app/im/v1/KPictureModule;Lkntr/app/im/chat/module/localPicture/LocalPictureModule;)V", "(Lkntr/app/im/chat/core/service/NetworkSendMessageService;Lkntr/common/paragraph/assetuploader/AssetUploader;Lcom/bapis/bilibili/app/im/v1/KEntityMsgType;Ljava/lang/String;JLkntr/app/im/chat/service/sender/image/LocalImageAsset;Lcom/bapis/bilibili/app/im/v1/KUserPlaceholder;ZLkntr/app/im/chat/network/MsgModuleTransformers;Lkntr/app/im/chat/core/service/MessageSendProgress;Lkntr/common/photonic/Resolution;Lkntr/common/photonic/Orientation;)V", "getCacheAsset", "()Lkntr/app/im/chat/service/sender/image/LocalImageAsset;", "getAssetUploader", "()Lkntr/common/paragraph/assetuploader/AssetUploader;", "getUseOriginImage", "()Z", "getUserPlaceholder", "()Lcom/bapis/bilibili/app/im/v1/KUserPlaceholder;", "getTransformers", "()Lkntr/app/im/chat/network/MsgModuleTransformers;", "getResolution", "()Lkntr/common/photonic/Resolution;", "getOrientation", "()Lkntr/common/photonic/Orientation;", "getMsgType", "()Lcom/bapis/bilibili/app/im/v1/KEntityMsgType;", "getToken", "()Ljava/lang/String;", "getSequenceOffset", "()J", "snapshotTask", "Landroidx/compose/runtime/MutableState;", "Lkntr/common/paragraph/assetuploader/UploadTask;", "progressState", "progress", "Landroidx/compose/runtime/State;", "getProgress", "()Landroidx/compose/runtime/State;", "webImageModule", "content", "Lkntr/app/im/chat/core/model/MsgFrame;", "getContent", "()Lkntr/app/im/chat/core/model/MsgFrame;", "init", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startUpload", "Lkotlinx/coroutines/flow/Flow;", "send", "Lkotlin/Result;", "Lkntr/app/im/chat/core/model/EntityMessage;", "send-IoAF18A", "updateState", RoomRecommendViewModel.EMPTY_CURSOR, "newState", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ImageMessageSendTask implements MessageTask {
    public static final int $stable = 8;
    private final AssetUploader assetUploader;
    private final LocalImageAsset cacheAsset;
    private final LocalPictureModule localPictureModule;
    private final KEntityMsgType msgType;
    private final NetworkSendMessageService networkSendMessageService;
    private final Orientation orientation;
    private final MutableState<MessageSendProgress> progressState;
    private final Resolution resolution;
    private final long sequenceOffset;
    private final MutableState<UploadTask> snapshotTask;
    private final String token;
    private final MsgModuleTransformers transformers;
    private final boolean useOriginImage;
    private final KUserPlaceholder userPlaceholder;
    private final MutableState<KPictureModule> webImageModule;

    public ImageMessageSendTask(NetworkSendMessageService networkSendMessageService, LocalImageAsset cacheAsset, AssetUploader assetUploader, boolean useOriginImage, KUserPlaceholder userPlaceholder, MsgModuleTransformers transformers, Resolution resolution, Orientation orientation, KEntityMsgType msgType, String token, long sequenceOffset, MessageSendProgress initState, KPictureModule webImage, LocalPictureModule localPictureModule) {
        Intrinsics.checkNotNullParameter(networkSendMessageService, "networkSendMessageService");
        Intrinsics.checkNotNullParameter(assetUploader, "assetUploader");
        Intrinsics.checkNotNullParameter(userPlaceholder, "userPlaceholder");
        Intrinsics.checkNotNullParameter(transformers, "transformers");
        Intrinsics.checkNotNullParameter(msgType, "msgType");
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(initState, "initState");
        this.networkSendMessageService = networkSendMessageService;
        this.cacheAsset = cacheAsset;
        this.assetUploader = assetUploader;
        this.useOriginImage = useOriginImage;
        this.userPlaceholder = userPlaceholder;
        this.transformers = transformers;
        this.resolution = resolution;
        this.orientation = orientation;
        this.msgType = msgType;
        this.token = token;
        this.sequenceOffset = sequenceOffset;
        this.localPictureModule = localPictureModule;
        this.snapshotTask = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.progressState = SnapshotStateKt.mutableStateOf$default(initState, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.webImageModule = SnapshotStateKt.mutableStateOf$default(webImage, (SnapshotMutationPolicy) null, 2, (Object) null);
        if (Intrinsics.areEqual(getMsgType(), KEntityMsgType.ENTITY_MSG_TYPE_PICTURE.INSTANCE) || Intrinsics.areEqual(getMsgType(), KEntityMsgType.ENTITY_MSG_TYPE_CUSTOM_STICKER.INSTANCE)) {
            return;
        }
        throw new IllegalArgumentException(("ImageMessageSendTask only supports picture or custom sticker message type, but got " + getMsgType()).toString());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ ImageMessageSendTask(NetworkSendMessageService networkSendMessageService, LocalImageAsset localImageAsset, AssetUploader assetUploader, boolean z, KUserPlaceholder kUserPlaceholder, MsgModuleTransformers msgModuleTransformers, Resolution resolution, Orientation orientation, KEntityMsgType kEntityMsgType, String str, long j2, MessageSendProgress messageSendProgress, KPictureModule kPictureModule, LocalPictureModule localPictureModule, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(networkSendMessageService, localImageAsset, assetUploader, z, kUserPlaceholder, msgModuleTransformers, r7, r8, kEntityMsgType, (i & 512) != 0 ? Uuid.Companion.random().toString() : str, j2, (i & 2048) != 0 ? MessageSendProgress.Init.INSTANCE : messageSendProgress, (i & 4096) != 0 ? null : kPictureModule, (i & 8192) != 0 ? null : localPictureModule);
        Resolution resolution2;
        Orientation orientation2;
        if ((i & 64) != 0) {
            resolution2 = localImageAsset != null ? localImageAsset.getResolution() : null;
        } else {
            resolution2 = resolution;
        }
        if ((i & 128) != 0) {
            orientation2 = localImageAsset != null ? localImageAsset.getOrientation() : null;
        } else {
            orientation2 = orientation;
        }
    }

    public final LocalImageAsset getCacheAsset() {
        return this.cacheAsset;
    }

    public final AssetUploader getAssetUploader() {
        return this.assetUploader;
    }

    public final boolean getUseOriginImage() {
        return this.useOriginImage;
    }

    public final KUserPlaceholder getUserPlaceholder() {
        return this.userPlaceholder;
    }

    public final MsgModuleTransformers getTransformers() {
        return this.transformers;
    }

    public final Resolution getResolution() {
        return this.resolution;
    }

    public final Orientation getOrientation() {
        return this.orientation;
    }

    @Override // kntr.app.im.chat.core.service.MessageTask
    public KEntityMsgType getMsgType() {
        return this.msgType;
    }

    @Override // kntr.app.im.chat.core.service.MessageTask
    public String getToken() {
        return this.token;
    }

    @Override // kntr.app.im.chat.core.service.MessageTask
    public long getSequenceOffset() {
        return this.sequenceOffset;
    }

    @Override // kntr.app.im.chat.core.service.MessageTask
    public State<MessageSendProgress> getProgress() {
        return this.progressState;
    }

    @Override // kntr.app.im.chat.core.service.MessageTask
    public MsgFrame getContent() {
        KPictureModule it = (KPictureModule) this.webImageModule.getValue();
        if (it != null) {
            KUserPlaceholder userPlaceholder$iv = this.userPlaceholder;
            List menu$iv = CollectionsKt.emptyList();
            MsgModuleTransformers transformers$iv = this.transformers;
            KBubbleStyle style$iv = KBubbleStyle.BUBBLE_STYLE_ROUND_CORNER.INSTANCE;
            List<KMsgModule> listOf = CollectionsKt.listOf(new KMsgModule(new KMsgModule.KPictureModule(it)));
            return new ChatBubbleFrame(new KChatBubbleFrame(new KTalkerInfo(new KTalkerInfo.KUserPlaceholder(userPlaceholder$iv)), true, menu$iv, listOf, style$iv, (KChatBubbleWidget) null, (String) null, 96, (DefaultConstructorMarker) null), transformers$iv.transformToMsgModules(listOf));
        }
        LocalPictureModule localPictureModule = this.localPictureModule;
        if (localPictureModule != null) {
            Object value = getProgress().getValue();
            MessageSendProgress.Uploading uploading = value instanceof MessageSendProgress.Uploading ? (MessageSendProgress.Uploading) value : null;
            float progress = uploading != null ? uploading.getProgress() : 0.0f;
            Resolution resolution = this.resolution;
            if (resolution == null) {
                resolution = this.localPictureModule.getResolution();
            }
            Resolution resolution2 = resolution;
            Orientation orientation = this.orientation;
            if (orientation == null) {
                orientation = this.localPictureModule.getOrientation();
            }
            LocalPictureModule it2 = LocalPictureModule.copy$default(localPictureModule, null, null, progress, null, resolution2, orientation, false, null, 203, null);
            if (it2 != null) {
                KUserPlaceholder userPlaceholder$iv2 = this.userPlaceholder;
                List menu$iv2 = CollectionsKt.emptyList();
                KBubbleStyle style$iv2 = KBubbleStyle.BUBBLE_STYLE_ROUND_CORNER.INSTANCE;
                return new ChatBubbleFrame(new KChatBubbleFrame(new KTalkerInfo(new KTalkerInfo.KUserPlaceholder(userPlaceholder$iv2)), true, menu$iv2, CollectionsKt.emptyList(), style$iv2, (KChatBubbleWidget) null, (String) null, 96, (DefaultConstructorMarker) null), CollectionsKt.listOf(it2));
            }
        }
        throw new IllegalArgumentException("Both webImageModule and localContent are null");
    }

    public /* synthetic */ ImageMessageSendTask(NetworkSendMessageService networkSendMessageService, AssetUploader assetUploader, KEntityMsgType kEntityMsgType, String str, long j2, LocalImageAsset localImageAsset, KUserPlaceholder kUserPlaceholder, boolean z, MsgModuleTransformers msgModuleTransformers, MessageSendProgress messageSendProgress, Resolution resolution, Orientation orientation, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(networkSendMessageService, assetUploader, kEntityMsgType, str, j2, localImageAsset, kUserPlaceholder, z, msgModuleTransformers, (i & 512) != 0 ? MessageSendProgress.Init.INSTANCE : messageSendProgress, (i & 1024) != 0 ? localImageAsset.getResolution() : resolution, (i & 2048) != 0 ? localImageAsset.getOrientation() : orientation);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ImageMessageSendTask(NetworkSendMessageService networkSendMessageService, AssetUploader assetUploader, KEntityMsgType msgType, String token, long sequenceOffset, LocalImageAsset cacheAsset, KUserPlaceholder userPlaceholder, boolean useOriginImage, MsgModuleTransformers transformers, MessageSendProgress initState, Resolution resolution, Orientation orientation) {
        this(networkSendMessageService, cacheAsset, assetUploader, useOriginImage, userPlaceholder, transformers, resolution, orientation, msgType, token, sequenceOffset, initState, (KPictureModule) null, new LocalPictureModule(cacheAsset, r3, 0.0f, r1 == null ? RoomRecommendViewModel.EMPTY_CURSOR : r1, r6, r7, useOriginImage, r0));
        Intrinsics.checkNotNullParameter(networkSendMessageService, "networkSendMessageService");
        Intrinsics.checkNotNullParameter(assetUploader, "assetUploader");
        Intrinsics.checkNotNullParameter(msgType, "msgType");
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(cacheAsset, "cacheAsset");
        Intrinsics.checkNotNullParameter(userPlaceholder, "userPlaceholder");
        Intrinsics.checkNotNullParameter(transformers, "transformers");
        Intrinsics.checkNotNullParameter(initState, "initState");
        String identifier = cacheAsset.getIdentifier();
        Resolution resolution2 = resolution == null ? cacheAsset.getResolution() : resolution;
        String mimeType = cacheAsset.getMimeType().toString();
        Orientation orientation2 = orientation == null ? cacheAsset.getOrientation() : orientation;
        String qualifiedName = Reflection.getOrCreateKotlinClass(cacheAsset.getClass()).getQualifiedName();
    }

    @Override // kntr.app.im.chat.core.service.MessageTask
    public Object init(Continuation<? super MsgFrame> continuation) {
        updateState(MessageSendProgress.Pending.INSTANCE);
        return getContent();
    }

    @Override // kntr.app.im.chat.core.service.MessageTask
    public Flow<MessageSendProgress> startUpload() {
        return FlowKt.channelFlow(new ImageMessageSendTask$startUpload$1(this, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00d9  */
    @Override // kntr.app.im.chat.core.service.MessageTask
    /* renamed from: send-IoAF18A */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo1358sendIoAF18A(Continuation<? super Result<EntityMessage>> continuation) {
        ImageMessageSendTask$send$1 imageMessageSendTask$send$1;
        Object obj;
        Throwable it;
        if (continuation instanceof ImageMessageSendTask$send$1) {
            imageMessageSendTask$send$1 = (ImageMessageSendTask$send$1) continuation;
            if ((imageMessageSendTask$send$1.label & Integer.MIN_VALUE) != 0) {
                imageMessageSendTask$send$1.label -= Integer.MIN_VALUE;
                Object $result = imageMessageSendTask$send$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (imageMessageSendTask$send$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        IMLog.Companion.i(ImageMessageSender.TAG, "Sending image message: " + getToken());
                        NetworkSendMessageService networkSendMessageService = this.networkSendMessageService;
                        EntityMessage entityMessage = new EntityMessage(0L, null, getMsgType(), getContent(), Clock.System.INSTANCE.now(), getToken(), false, null, null, null, false, false, null, 8131, null);
                        imageMessageSendTask$send$1.label = 1;
                        Object mo1362sendgIAlus = networkSendMessageService.mo1362sendgIAlus(entityMessage, imageMessageSendTask$send$1);
                        if (mo1362sendgIAlus == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj = mo1362sendgIAlus;
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        obj = ((Result) $result).unbox-impl();
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (Result.isSuccess-impl(obj)) {
                    EntityMessage serverMessage = (EntityMessage) obj;
                    IMLog.Companion.i(ImageMessageSender.TAG, "Image message sent successfully: " + getToken());
                    updateState(new MessageSendProgress.SendSuccess(serverMessage));
                }
                it = Result.exceptionOrNull-impl(obj);
                if (it != null) {
                    IMLog.Companion.e(ImageMessageSender.TAG, "Failed to send image message", it);
                    MutableState<MessageSendProgress> mutableState = this.progressState;
                    IllegalStateException illegalStateException = it instanceof Exception ? (Exception) it : null;
                    if (illegalStateException == null) {
                        illegalStateException = new IllegalStateException("Fail to send");
                    }
                    mutableState.setValue(new MessageSendProgress.SendFailed(illegalStateException));
                }
                return obj;
            }
        }
        imageMessageSendTask$send$1 = new ImageMessageSendTask$send$1(this, continuation);
        Object $result2 = imageMessageSendTask$send$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (imageMessageSendTask$send$1.label) {
        }
        if (Result.isSuccess-impl(obj)) {
        }
        it = Result.exceptionOrNull-impl(obj);
        if (it != null) {
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateState(final MessageSendProgress newState) {
        IMLog.Companion.d(ImageMessageSender.TAG, new Function0() { // from class: kntr.app.im.chat.service.sender.image.ImageMessageSendTask$$ExternalSyntheticLambda0
            public final Object invoke() {
                String updateState$lambda$0;
                updateState$lambda$0 = ImageMessageSendTask.updateState$lambda$0(ImageMessageSendTask.this, newState);
                return updateState$lambda$0;
            }
        });
        this.progressState.setValue(newState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String updateState$lambda$0(ImageMessageSendTask this$0, MessageSendProgress $newState) {
        String token = this$0.getToken();
        return "ImageMessageSendTask[" + token + "] state changed: " + this$0.progressState.getValue() + " -> " + $newState;
    }
}