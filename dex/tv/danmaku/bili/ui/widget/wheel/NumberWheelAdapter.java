package tv.danmaku.bili.ui.widget.wheel;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BirthdayPickerView.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0017\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\u000eJ#\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00120\u0011H\u0016¢\u0006\u0002\u0010\u0013R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Ltv/danmaku/bili/ui/widget/wheel/NumberWheelAdapter;", "Ltv/danmaku/bili/ui/widget/wheel/WheelAdapter;", "", "data", "", "<init>", "(Ljava/util/List;)V", "itemsCount", "getItemsCount", "()I", "getItemContent", "", "index", "getItem", "(I)Ljava/lang/Integer;", "indexOf", "predicate", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Integer;", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class NumberWheelAdapter implements WheelAdapter<Integer> {
    private final List<Integer> data;

    public NumberWheelAdapter(List<Integer> list) {
        Intrinsics.checkNotNullParameter(list, "data");
        this.data = list;
    }

    @Override // tv.danmaku.bili.ui.widget.wheel.WheelAdapter
    public int getItemsCount() {
        return this.data.size();
    }

    @Override // tv.danmaku.bili.ui.widget.wheel.WheelAdapter
    public String getItemContent(int index) {
        String valueOf;
        Integer num = (Integer) CollectionsKt.getOrNull(this.data, index);
        return (num == null || (valueOf = String.valueOf(num.intValue())) == null) ? "" : valueOf;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // tv.danmaku.bili.ui.widget.wheel.WheelAdapter
    public Integer getItem(int index) {
        return (Integer) CollectionsKt.getOrNull(this.data, index);
    }

    @Override // tv.danmaku.bili.ui.widget.wheel.WheelAdapter
    public Integer indexOf(Function1<? super Integer, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        List $this$indexOfFirst$iv = this.data;
        int index$iv = 0;
        Iterator<Integer> it = $this$indexOfFirst$iv.iterator();
        while (true) {
            if (it.hasNext()) {
                Object item$iv = it.next();
                if (((Boolean) function1.invoke(item$iv)).booleanValue()) {
                    break;
                }
                index$iv++;
            } else {
                index$iv = -1;
                break;
            }
        }
        Integer valueOf = Integer.valueOf(index$iv);
        int it2 = valueOf.intValue();
        if (it2 >= 0) {
            return valueOf;
        }
        return null;
    }
}