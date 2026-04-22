package video.biz.offline.base.model.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.base.utils.VBStriingExtKt;

/* compiled from: TypeConverter.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0016\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¨\u0006\n"}, d2 = {"Lvideo/biz/offline/base/model/entity/LongListConverter;", "", "<init>", "()V", "revertLongList", "", "", "value", "", "converterLongList", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class LongListConverter {
    public static final int $stable = 0;

    public final List<Long> revertLongList(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        Iterable $this$map$iv = StringsKt.split$default(value, new String[]{","}, false, 0, 6, (Object) null);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            String it = (String) item$iv$iv;
            destination$iv$iv.add(Long.valueOf(VBStriingExtKt.toLongOrZero(it)));
        }
        return CollectionsKt.toMutableList((List) destination$iv$iv);
    }

    public final String converterLongList(List<Long> list) {
        Intrinsics.checkNotNullParameter(list, "value");
        return CollectionsKt.joinToString$default(list, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }
}