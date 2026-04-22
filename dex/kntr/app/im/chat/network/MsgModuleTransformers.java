package kntr.app.im.chat.network;

import com.bapis.bilibili.app.im.v1.KMsgModule;
import im.base.IMLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kntr.app.im.chat.core.model.MsgModule;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;

/* compiled from: MsgModuleTransformer.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B3\u0012\"\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\u0006\u0012\u0006\b\u0001\u0012\u00020\u00070\u00050\u0003\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u0014R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\f\u001a&\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\r\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\u0006\u0012\u0006\b\u0001\u0012\u00020\u00070\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lkntr/app/im/chat/network/MsgModuleTransformers;", RoomRecommendViewModel.EMPTY_CURSOR, "transformerMap", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/network/MsgModuleTransformer;", "Lcom/bapis/bilibili/app/im/v1/KMsgModule$IModule;", "Lkntr/app/im/chat/core/model/MsgModule;", "defaultModuleTransformer", "Lkntr/app/im/chat/network/DefaultModuleTransformer;", "<init>", "(Ljava/util/Map;Lkntr/app/im/chat/network/DefaultModuleTransformer;)V", "map", "Lkotlin/reflect/KClass;", "transformToMsgModule", "kMsg", "Lcom/bapis/bilibili/app/im/v1/KMsgModule;", "index", RoomRecommendViewModel.EMPTY_CURSOR, "transformToMsgModules", RoomRecommendViewModel.EMPTY_CURSOR, "kMsgModules", "network_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MsgModuleTransformers {
    private final DefaultModuleTransformer defaultModuleTransformer;
    private final Map<KClass<? extends KMsgModule.IModule>, MsgModuleTransformer<? extends KMsgModule.IModule, ? extends MsgModule>> map;

    public MsgModuleTransformers(Map<String, ? extends MsgModuleTransformer<? extends KMsgModule.IModule, ? extends MsgModule>> map, DefaultModuleTransformer defaultModuleTransformer) {
        Intrinsics.checkNotNullParameter(map, "transformerMap");
        Intrinsics.checkNotNullParameter(defaultModuleTransformer, "defaultModuleTransformer");
        this.defaultModuleTransformer = defaultModuleTransformer;
        Iterable $this$associateBy$iv = map.values();
        int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateBy$iv, 10)), 16);
        Map destination$iv$iv = new LinkedHashMap(capacity$iv);
        for (Object element$iv$iv : $this$associateBy$iv) {
            MsgModuleTransformer it = (MsgModuleTransformer) element$iv$iv;
            destination$iv$iv.put(it.getKType(), element$iv$iv);
        }
        this.map = destination$iv$iv;
        IMLog.Companion.i("NetworkMsgModuleTransformers", "Registered Network MsgModule transformers: " + CollectionsKt.joinToString$default(this.map.values(), "\n", "[", "]", 0, (CharSequence) null, new Function1() { // from class: kntr.app.im.chat.network.MsgModuleTransformers$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                CharSequence _init_$lambda$0;
                _init_$lambda$0 = MsgModuleTransformers._init_$lambda$0((MsgModuleTransformer) obj);
                return _init_$lambda$0;
            }
        }, 24, (Object) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence _init_$lambda$0(MsgModuleTransformer it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String simpleName = it.getKType().getSimpleName();
        return simpleName + " -> " + Reflection.getOrCreateKotlinClass(it.getClass()).getSimpleName() + ",";
    }

    public final MsgModule transformToMsgModule(KMsgModule kMsg, int index) {
        MsgModule transformToMsgModule;
        Intrinsics.checkNotNullParameter(kMsg, "kMsg");
        KMsgModule.IModule module = kMsg.getModule();
        if (module == null) {
            return this.defaultModuleTransformer.buildDefaultModule(null, index);
        }
        MsgModuleTransformer<? extends KMsgModule.IModule, ? extends MsgModule> msgModuleTransformer = this.map.get(Reflection.getOrCreateKotlinClass(module.getClass()));
        MsgModuleTransformer<? extends KMsgModule.IModule, ? extends MsgModule> msgModuleTransformer2 = msgModuleTransformer instanceof MsgModuleTransformer ? msgModuleTransformer : null;
        return (msgModuleTransformer2 == null || (transformToMsgModule = msgModuleTransformer2.transformToMsgModule(module, index)) == null) ? this.defaultModuleTransformer.buildDefaultModule(module, index) : transformToMsgModule;
    }

    public final List<MsgModule> transformToMsgModules(List<KMsgModule> list) {
        Intrinsics.checkNotNullParameter(list, "kMsgModules");
        List<KMsgModule> $this$mapIndexed$iv = list;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
        int index$iv$iv = 0;
        for (Object item$iv$iv : $this$mapIndexed$iv) {
            int index$iv$iv2 = index$iv$iv + 1;
            if (index$iv$iv < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            KMsgModule kMsgModule = (KMsgModule) item$iv$iv;
            destination$iv$iv.add(transformToMsgModule(kMsgModule, index$iv$iv));
            index$iv$iv = index$iv$iv2;
        }
        List resultList = (List) destination$iv$iv;
        int index$iv = 0;
        Iterator it = resultList.iterator();
        while (true) {
            if (it.hasNext()) {
                Object item$iv = it.next();
                MsgModule it2 = (MsgModule) item$iv;
                if (it2 instanceof MsgModule.UnknownModule) {
                    break;
                }
                index$iv++;
            } else {
                index$iv = -1;
                break;
            }
        }
        int unknownModule = index$iv;
        boolean z = false;
        if (unknownModule >= 0 && unknownModule < resultList.size()) {
            z = true;
        }
        if (!z) {
            return resultList;
        }
        IMLog.Companion.w("NetworkMsgModuleTransformers", "Module type " + Reflection.getOrCreateKotlinClass(list.get(unknownModule).getClass()) + " failed to transform, first unknown module at index " + unknownModule);
        return CollectionsKt.listOf(resultList.get(unknownModule));
    }
}