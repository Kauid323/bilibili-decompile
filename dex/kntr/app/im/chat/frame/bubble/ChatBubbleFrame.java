package kntr.app.im.chat.frame.bubble;

import com.bapis.bilibili.app.im.v1.KChatBubbleFrame;
import com.bapis.bilibili.app.im.v1.KChatBubbleFrame$;
import com.bapis.bilibili.app.im.v1.KTalkerInfo;
import com.bapis.bilibili.dagw.component.avatar.v1.KAvatarItem;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.Lens;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kntr.app.im.chat.core.model.MsgFrame;
import kntr.app.im.chat.core.model.MsgModule;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.compose.avatar.parser.protobuf.AvatarKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.PolymorphicSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.Transient;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: ChatBubbleFrame.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 12\u00020\u0001:\u000212B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bB5\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\u000e\u0010\u0018\u001a\u00020\u0001H\u0096@¢\u0006\u0002\u0010\u0019J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\nHÖ\u0001J\t\u0010'\u001a\u00020(HÖ\u0001J%\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0001¢\u0006\u0002\b0R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R,\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u001b8VX\u0096\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u0015\u001a\u0004\b\u001d\u0010\u001e¨\u00063"}, d2 = {"Lkntr/app/im/chat/frame/bubble/ChatBubbleFrame;", "Lkntr/app/im/chat/core/model/MsgFrame;", "value", "Lcom/bapis/bilibili/app/im/v1/KChatBubbleFrame;", "modules", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/core/model/MsgModule;", "<init>", "(Lcom/bapis/bilibili/app/im/v1/KChatBubbleFrame;Ljava/util/List;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/bapis/bilibili/app/im/v1/KChatBubbleFrame;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getValue", "()Lcom/bapis/bilibili/app/im/v1/KChatBubbleFrame;", "getModules", "()Ljava/util/List;", "userInfo", "Lkntr/app/im/chat/frame/bubble/UserInfoHolder;", "getUserInfo$annotations", "()V", "getUserInfo", "()Lkntr/app/im/chat/frame/bubble/UserInfoHolder;", "restoreFrame", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "modulesLens", "Lcom/bilibili/blens/BSimpleLens;", "getModulesLens$annotations", "getModulesLens", "()Lcom/bilibili/blens/BSimpleLens;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", "toString", RoomRecommendViewModel.EMPTY_CURSOR, "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$biz_debug", "Companion", "$serializer", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
@Lens
public final class ChatBubbleFrame implements MsgFrame {
    public static final int $stable = 0;
    private final List<MsgModule> modules;
    private final UserInfoHolder userInfo;
    private final KChatBubbleFrame value;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.im.chat.frame.bubble.ChatBubbleFrame$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = ChatBubbleFrame._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    })};

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChatBubbleFrame copy$default(ChatBubbleFrame chatBubbleFrame, KChatBubbleFrame kChatBubbleFrame, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            kChatBubbleFrame = chatBubbleFrame.value;
        }
        if ((i & 2) != 0) {
            list = chatBubbleFrame.modules;
        }
        return chatBubbleFrame.copy(kChatBubbleFrame, list);
    }

    public static /* synthetic */ void getModulesLens$annotations() {
    }

    @Transient
    public static /* synthetic */ void getUserInfo$annotations() {
    }

    public final KChatBubbleFrame component1() {
        return this.value;
    }

    public final List<MsgModule> component2() {
        return this.modules;
    }

    public final ChatBubbleFrame copy(KChatBubbleFrame kChatBubbleFrame, List<? extends MsgModule> list) {
        Intrinsics.checkNotNullParameter(kChatBubbleFrame, "value");
        Intrinsics.checkNotNullParameter(list, "modules");
        return new ChatBubbleFrame(kChatBubbleFrame, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChatBubbleFrame) {
            ChatBubbleFrame chatBubbleFrame = (ChatBubbleFrame) obj;
            return Intrinsics.areEqual(this.value, chatBubbleFrame.value) && Intrinsics.areEqual(this.modules, chatBubbleFrame.modules);
        }
        return false;
    }

    public int hashCode() {
        return (this.value.hashCode() * 31) + this.modules.hashCode();
    }

    public String toString() {
        KChatBubbleFrame kChatBubbleFrame = this.value;
        return "ChatBubbleFrame(value=" + kChatBubbleFrame + ", modules=" + this.modules + ")";
    }

    public /* synthetic */ ChatBubbleFrame(int seen0, KChatBubbleFrame value, List modules, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (seen0 & 3)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 3, ChatBubbleFrame$$serializer.INSTANCE.getDescriptor());
        }
        this.value = value;
        this.modules = modules;
        KTalkerInfo senderInfo = this.value.getSenderInfo();
        KTalkerInfo.KUserTalkerInfo info = senderInfo != null ? senderInfo.getInfo() : null;
        if (info instanceof KTalkerInfo.KUserTalkerInfo) {
            KAvatarItem avatar = info.getValue().getAvatar();
            r1 = new UserInfoHolder(avatar != null ? AvatarKt.toAvatarItem(avatar) : null, info.getValue().getAvatarUrl());
        }
        this.userInfo = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChatBubbleFrame(KChatBubbleFrame value, List<? extends MsgModule> list) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(list, "modules");
        this.value = value;
        this.modules = list;
        KTalkerInfo senderInfo = this.value.getSenderInfo();
        KTalkerInfo.KUserTalkerInfo info = senderInfo != null ? senderInfo.getInfo() : null;
        if (info instanceof KTalkerInfo.KUserTalkerInfo) {
            KAvatarItem avatar = info.getValue().getAvatar();
            r1 = new UserInfoHolder(avatar != null ? AvatarKt.toAvatarItem(avatar) : null, info.getValue().getAvatarUrl());
        }
        this.userInfo = r1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(new PolymorphicSerializer(Reflection.getOrCreateKotlinClass(MsgModule.class), new Annotation[0]));
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$biz_debug(ChatBubbleFrame self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        output.encodeSerializableElement(serialDesc, 0, KChatBubbleFrame$.serializer.INSTANCE, self.value);
        output.encodeSerializableElement(serialDesc, 1, (SerializationStrategy) lazyArr[1].getValue(), self.getModules());
    }

    @Override // kntr.app.im.chat.core.model.MsgFrame
    public /* bridge */ boolean getRequireUpdate() {
        return MsgFrame.CC.$default$getRequireUpdate(this);
    }

    public final KChatBubbleFrame getValue() {
        return this.value;
    }

    @Override // kntr.app.im.chat.core.model.MsgFrame
    public List<MsgModule> getModules() {
        return this.modules;
    }

    /* compiled from: ChatBubbleFrame.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/im/chat/frame/bubble/ChatBubbleFrame$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/im/chat/frame/bubble/ChatBubbleFrame;", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ChatBubbleFrame> serializer() {
            return ChatBubbleFrame$$serializer.INSTANCE;
        }
    }

    public final UserInfoHolder getUserInfo() {
        return this.userInfo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00fd  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x00d3 -> B:20:0x00e9). Please submit an issue!!! */
    @Override // kntr.app.im.chat.core.model.MsgFrame
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object restoreFrame(Continuation<? super MsgFrame> continuation) {
        ChatBubbleFrame$restoreFrame$1 chatBubbleFrame$restoreFrame$1;
        ChatBubbleFrame chatBubbleFrame;
        ChatBubbleFrame chatBubbleFrame2;
        Iterable item$iv$iv;
        Iterator it;
        ChatBubbleFrame chatBubbleFrame3;
        int $i$f$mapTo;
        Iterable $this$map$iv;
        KChatBubbleFrame kChatBubbleFrame;
        Collection destination$iv$iv;
        int $i$f$mapTo2;
        Iterable $this$mapTo$iv$iv;
        Collection destination$iv$iv2;
        int $i$f$map;
        int $i$f$map2;
        Iterable $this$map$iv2;
        KChatBubbleFrame kChatBubbleFrame2;
        Iterator it2;
        ChatBubbleFrame chatBubbleFrame4;
        ChatBubbleFrame chatBubbleFrame5;
        Collection collection;
        Object $result;
        Continuation $completion = continuation;
        if ($completion instanceof ChatBubbleFrame$restoreFrame$1) {
            chatBubbleFrame$restoreFrame$1 = (ChatBubbleFrame$restoreFrame$1) $completion;
            if ((chatBubbleFrame$restoreFrame$1.label & Integer.MIN_VALUE) != 0) {
                chatBubbleFrame$restoreFrame$1.label -= Integer.MIN_VALUE;
                chatBubbleFrame = this;
                Object $result2 = chatBubbleFrame$restoreFrame$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (chatBubbleFrame$restoreFrame$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result2);
                        Iterable $this$map$iv3 = getModules();
                        Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                        chatBubbleFrame2 = chatBubbleFrame;
                        item$iv$iv = $this$map$iv3;
                        it = $this$map$iv3.iterator();
                        chatBubbleFrame3 = chatBubbleFrame2;
                        $i$f$mapTo = 0;
                        $this$map$iv = $this$map$iv3;
                        kChatBubbleFrame = null;
                        destination$iv$iv = destination$iv$iv3;
                        $i$f$mapTo2 = 0;
                        break;
                    case 1:
                        int i = chatBubbleFrame$restoreFrame$1.I$2;
                        int $i$f$mapTo3 = chatBubbleFrame$restoreFrame$1.I$1;
                        int $i$f$map3 = chatBubbleFrame$restoreFrame$1.I$0;
                        MsgModule msgModule = (MsgModule) chatBubbleFrame$restoreFrame$1.L$5;
                        Object obj = chatBubbleFrame$restoreFrame$1.L$4;
                        destination$iv$iv2 = (Collection) chatBubbleFrame$restoreFrame$1.L$2;
                        Iterable $this$mapTo$iv$iv2 = (Iterable) chatBubbleFrame$restoreFrame$1.L$1;
                        ResultKt.throwOnFailure($result2);
                        it2 = (Iterator) chatBubbleFrame$restoreFrame$1.L$3;
                        $this$mapTo$iv$iv = $this$mapTo$iv$iv2;
                        chatBubbleFrame4 = chatBubbleFrame;
                        $result = $result2;
                        chatBubbleFrame5 = (ChatBubbleFrame) chatBubbleFrame$restoreFrame$1.L$6;
                        collection = (Collection) chatBubbleFrame$restoreFrame$1.L$7;
                        $i$f$map = $i$f$map3;
                        $i$f$map2 = $i$f$mapTo3;
                        $this$map$iv2 = (Iterable) chatBubbleFrame$restoreFrame$1.L$0;
                        kChatBubbleFrame2 = null;
                        collection.add((MsgModule) $result2);
                        $result2 = $result;
                        kChatBubbleFrame = kChatBubbleFrame2;
                        $this$map$iv = $this$map$iv2;
                        $i$f$mapTo2 = $i$f$map2;
                        $i$f$mapTo = $i$f$map;
                        chatBubbleFrame3 = chatBubbleFrame5;
                        chatBubbleFrame2 = chatBubbleFrame4;
                        destination$iv$iv = destination$iv$iv2;
                        it = it2;
                        item$iv$iv = $this$mapTo$iv$iv;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (it.hasNext()) {
                    Object item$iv$iv2 = it.next();
                    MsgModule it3 = (MsgModule) item$iv$iv2;
                    Continuation $completion2 = $completion;
                    chatBubbleFrame$restoreFrame$1.L$0 = SpillingKt.nullOutSpilledVariable($this$map$iv);
                    chatBubbleFrame$restoreFrame$1.L$1 = SpillingKt.nullOutSpilledVariable(item$iv$iv);
                    chatBubbleFrame$restoreFrame$1.L$2 = destination$iv$iv;
                    chatBubbleFrame$restoreFrame$1.L$3 = it;
                    chatBubbleFrame$restoreFrame$1.L$4 = SpillingKt.nullOutSpilledVariable(item$iv$iv2);
                    chatBubbleFrame$restoreFrame$1.L$5 = SpillingKt.nullOutSpilledVariable(it3);
                    chatBubbleFrame$restoreFrame$1.L$6 = chatBubbleFrame3;
                    chatBubbleFrame$restoreFrame$1.L$7 = destination$iv$iv;
                    chatBubbleFrame$restoreFrame$1.I$0 = $i$f$mapTo;
                    chatBubbleFrame$restoreFrame$1.I$1 = $i$f$mapTo2;
                    chatBubbleFrame$restoreFrame$1.I$2 = 0;
                    chatBubbleFrame$restoreFrame$1.label = 1;
                    Object rebuildModule = it3.rebuildModule(chatBubbleFrame$restoreFrame$1);
                    if (rebuildModule == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $this$mapTo$iv$iv = item$iv$iv;
                    destination$iv$iv2 = destination$iv$iv;
                    $i$f$map = $i$f$mapTo;
                    $i$f$map2 = $i$f$mapTo2;
                    $this$map$iv2 = $this$map$iv;
                    kChatBubbleFrame2 = kChatBubbleFrame;
                    $completion = $completion2;
                    it2 = it;
                    chatBubbleFrame4 = chatBubbleFrame2;
                    chatBubbleFrame5 = chatBubbleFrame3;
                    collection = destination$iv$iv2;
                    Object obj2 = $result2;
                    $result2 = rebuildModule;
                    $result = obj2;
                    collection.add((MsgModule) $result2);
                    $result2 = $result;
                    kChatBubbleFrame = kChatBubbleFrame2;
                    $this$map$iv = $this$map$iv2;
                    $i$f$mapTo2 = $i$f$map2;
                    $i$f$mapTo = $i$f$map;
                    chatBubbleFrame3 = chatBubbleFrame5;
                    chatBubbleFrame2 = chatBubbleFrame4;
                    destination$iv$iv = destination$iv$iv2;
                    it = it2;
                    item$iv$iv = $this$mapTo$iv$iv;
                    if (it.hasNext()) {
                        return copy$default(chatBubbleFrame3, kChatBubbleFrame, (List) destination$iv$iv, 1, null);
                    }
                }
            }
        }
        chatBubbleFrame = this;
        chatBubbleFrame$restoreFrame$1 = new ChatBubbleFrame$restoreFrame$1(chatBubbleFrame, $completion);
        Object $result22 = chatBubbleFrame$restoreFrame$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (chatBubbleFrame$restoreFrame$1.label) {
        }
        if (it.hasNext()) {
        }
    }

    @Override // kntr.app.im.chat.core.model.MsgFrame
    public BSimpleLens<MsgFrame, List<MsgModule>> getModulesLens() {
        BSimpleLens<ChatBubbleFrame, List<MsgModule>> modules = ChatBubbleFrameLensKt.getModules(Companion);
        Intrinsics.checkNotNull(modules, "null cannot be cast to non-null type com.bilibili.blens.BSimpleLens<kntr.app.im.chat.core.model.MsgFrame, kotlin.collections.List<kntr.app.im.chat.core.model.MsgModule>>");
        return modules;
    }
}