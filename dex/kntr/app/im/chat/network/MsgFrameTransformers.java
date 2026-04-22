package kntr.app.im.chat.network;

import com.bapis.bilibili.app.im.v1.KMsgFrame;
import im.base.IMLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kntr.app.im.chat.core.model.MsgFrame;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;

/* compiled from: MsgFrameTransformer.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B8\u0012'\u0010\u0002\u001a#\u0012\u0004\u0012\u00020\u0004\u0012\u0019\u0012\u0017\u0012\u0006\b\u0001\u0012\u00020\u0006\u0012\u0006\b\u0001\u0012\u00020\u00070\u0005¢\u0006\u0002\b\b0\u0003\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\u0007R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R7\u0010\r\u001a+\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u000e\u0012\u0019\u0012\u0017\u0012\u0006\b\u0001\u0012\u00020\u0006\u0012\u0006\b\u0001\u0012\u00020\u00070\u0005¢\u0006\u0002\b\b0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R7\u0010\u000f\u001a+\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u000e\u0012\u0019\u0012\u0017\u0012\u0006\b\u0001\u0012\u00020\u0006\u0012\u0006\b\u0001\u0012\u00020\u00070\u0005¢\u0006\u0002\b\b0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lkntr/app/im/chat/network/MsgFrameTransformers;", RoomRecommendViewModel.EMPTY_CURSOR, "transformerMap", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/network/MsgFrameTransformer;", "Lcom/bapis/bilibili/app/im/v1/KMsgFrame$IFrame;", "Lkntr/app/im/chat/core/model/MsgFrame;", "Lkotlin/jvm/JvmSuppressWildcards;", "defaultFrameTransformer", "Lkntr/app/im/chat/network/DefaultFrameTransformer;", "<init>", "(Ljava/util/Map;Lkntr/app/im/chat/network/DefaultFrameTransformer;)V", "kMap", "Lkotlin/reflect/KClass;", "map", "transformToMsgFrame", "kFrame", "Lcom/bapis/bilibili/app/im/v1/KMsgFrame;", "transformToKFrame", "msgFrame", "network_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MsgFrameTransformers {
    private final DefaultFrameTransformer defaultFrameTransformer;
    private final Map<KClass<? extends KMsgFrame.IFrame>, MsgFrameTransformer<? extends KMsgFrame.IFrame, ? extends MsgFrame>> kMap;
    private final Map<KClass<? extends MsgFrame>, MsgFrameTransformer<? extends KMsgFrame.IFrame, ? extends MsgFrame>> map;

    public MsgFrameTransformers(Map<String, MsgFrameTransformer<? extends KMsgFrame.IFrame, ? extends MsgFrame>> map, DefaultFrameTransformer defaultFrameTransformer) {
        Intrinsics.checkNotNullParameter(map, "transformerMap");
        Intrinsics.checkNotNullParameter(defaultFrameTransformer, "defaultFrameTransformer");
        this.defaultFrameTransformer = defaultFrameTransformer;
        Iterable $this$associateBy$iv = map.values();
        int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateBy$iv, 10)), 16);
        Map destination$iv$iv = new LinkedHashMap(capacity$iv);
        for (Object element$iv$iv : $this$associateBy$iv) {
            MsgFrameTransformer it = (MsgFrameTransformer) element$iv$iv;
            destination$iv$iv.put(it.getKType(), element$iv$iv);
        }
        this.kMap = destination$iv$iv;
        Iterable $this$associateBy$iv2 = map.values();
        int capacity$iv2 = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateBy$iv2, 10)), 16);
        Map destination$iv$iv2 = new LinkedHashMap(capacity$iv2);
        for (Object element$iv$iv2 : $this$associateBy$iv2) {
            MsgFrameTransformer it2 = (MsgFrameTransformer) element$iv$iv2;
            destination$iv$iv2.put(it2.getType(), element$iv$iv2);
        }
        this.map = destination$iv$iv2;
        IMLog.Companion.i("NetworkMsgFrameTransformers", "Registered Network MsgFrame Transformers: " + CollectionsKt.joinToString$default(this.kMap.values(), "\n", "[", "]", 0, (CharSequence) null, new Function1() { // from class: kntr.app.im.chat.network.MsgFrameTransformers$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                CharSequence _init_$lambda$0;
                _init_$lambda$0 = MsgFrameTransformers._init_$lambda$0((MsgFrameTransformer) obj);
                return _init_$lambda$0;
            }
        }, 24, (Object) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence _init_$lambda$0(MsgFrameTransformer it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String simpleName = it.getKType().getSimpleName();
        return simpleName + " -> " + Reflection.getOrCreateKotlinClass(it.getClass()).getSimpleName() + ",";
    }

    public final MsgFrame transformToMsgFrame(KMsgFrame kFrame) {
        MsgFrame transformToMsgFrame;
        Intrinsics.checkNotNullParameter(kFrame, "kFrame");
        KMsgFrame.IFrame frame = kFrame.getFrame();
        if (frame == null) {
            return this.defaultFrameTransformer.buildDefaultFrame(null);
        }
        MsgFrameTransformer msgFrameTransformer = this.kMap.get(Reflection.getOrCreateKotlinClass(frame.getClass()));
        MsgFrameTransformer transformer = msgFrameTransformer instanceof MsgFrameTransformer ? msgFrameTransformer : null;
        return (transformer == null || (transformToMsgFrame = transformer.transformToMsgFrame(frame)) == null) ? this.defaultFrameTransformer.buildDefaultFrame(frame) : transformToMsgFrame;
    }

    public final KMsgFrame transformToKFrame(MsgFrame msgFrame) {
        Intrinsics.checkNotNullParameter(msgFrame, "msgFrame");
        MsgFrameTransformer msgFrameTransformer = this.map.get(Reflection.getOrCreateKotlinClass(msgFrame.getClass()));
        MsgFrameTransformer transformer = msgFrameTransformer instanceof MsgFrameTransformer ? msgFrameTransformer : null;
        if (transformer == null) {
            return null;
        }
        return transformer.transformToKFrame(msgFrame);
    }
}