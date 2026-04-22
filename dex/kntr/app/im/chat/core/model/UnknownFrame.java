package kntr.app.im.chat.core.model;

import com.bilibili.blens.BSetter;
import com.bilibili.blens.BSimpleLens;
import java.lang.annotation.Annotation;
import java.util.List;
import kntr.app.im.chat.core.model.MsgFrame;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.ObjectSerializer;

/* compiled from: MsgFrame.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00000\u0017J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR&\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lkntr/app/im/chat/core/model/UnknownFrame;", "Lkntr/app/im/chat/core/model/MsgFrame;", "<init>", "()V", "modules", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/core/model/MsgModule;", "getModules", "()Ljava/util/List;", "modulesLens", "Lcom/bilibili/blens/BSimpleLens;", "getModulesLens", "()Lcom/bilibili/blens/BSimpleLens;", "requireUpdate", RoomRecommendViewModel.EMPTY_CURSOR, "getRequireUpdate", "()Z", "equals", "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "serializer", "Lkotlinx/serialization/KSerializer;", "toString", RoomRecommendViewModel.EMPTY_CURSOR, "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class UnknownFrame implements MsgFrame {
    public static final int $stable = 0;
    public static final UnknownFrame INSTANCE = new UnknownFrame();
    private static final BSimpleLens<MsgFrame, List<MsgModule>> modulesLens = new BSimpleLens<MsgFrame, List<? extends MsgModule>>() { // from class: kntr.app.im.chat.core.model.UnknownFrame$modulesLens$1
        public /* bridge */ /* synthetic */ Object modify(Object source, Function1 map) {
            return modify((MsgFrame) source, (Function1<? super List<? extends MsgModule>, ? extends List<? extends MsgModule>>) map);
        }

        public /* bridge */ MsgFrame set(MsgFrame source, List<? extends MsgModule> list) {
            return (MsgFrame) BSetter.-CC.$default$set(this, source, list);
        }

        public List<MsgModule> get(MsgFrame source) {
            Intrinsics.checkNotNullParameter(source, "source");
            return UnknownFrame.INSTANCE.getModules();
        }

        public MsgFrame modify(MsgFrame source, Function1<? super List<? extends MsgModule>, ? extends List<? extends MsgModule>> function1) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(function1, "map");
            return source;
        }
    };
    private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.im.chat.core.model.UnknownFrame$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _init_$_anonymous_;
            _init_$_anonymous_ = UnknownFrame._init_$_anonymous_();
            return _init_$_anonymous_;
        }
    });

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UnknownFrame) {
            UnknownFrame unknownFrame = (UnknownFrame) obj;
            return true;
        }
        return false;
    }

    public int hashCode() {
        return 1797120145;
    }

    public String toString() {
        return "UnknownFrame";
    }

    private UnknownFrame() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _init_$_anonymous_() {
        return new ObjectSerializer("kntr.app.im.chat.core.model.UnknownFrame", INSTANCE, new Annotation[0]);
    }

    private final /* synthetic */ KSerializer get$cachedSerializer() {
        return (KSerializer) $cachedSerializer$delegate.getValue();
    }

    @Override // kntr.app.im.chat.core.model.MsgFrame
    public /* bridge */ Object restoreFrame(Continuation<? super MsgFrame> continuation) {
        return MsgFrame.CC.restoreFrame$suspendImpl(this, continuation);
    }

    public final KSerializer<UnknownFrame> serializer() {
        return get$cachedSerializer();
    }

    @Override // kntr.app.im.chat.core.model.MsgFrame
    public List<MsgModule> getModules() {
        return CollectionsKt.emptyList();
    }

    @Override // kntr.app.im.chat.core.model.MsgFrame
    public BSimpleLens<MsgFrame, List<MsgModule>> getModulesLens() {
        return modulesLens;
    }

    @Override // kntr.app.im.chat.core.model.MsgFrame
    public boolean getRequireUpdate() {
        return true;
    }
}