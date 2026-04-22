package kntr.app.mall.mallDynamicPage.bean;

import java.util.Map;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UIProtocol.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lkntr/app/mall/mallDynamicPage/bean/Func;", RoomRecommendViewModel.EMPTY_CURSOR, "name", RoomRecommendViewModel.EMPTY_CURSOR, "params", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;Ljava/util/Map;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getParams", "()Ljava/util/Map;", "setParams", "(Ljava/util/Map;)V", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "mallDynamicPage_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Func {
    public static final int $stable = 8;
    private String name;
    private Map<String, ? extends Object> params;

    public Func() {
        this(null, null, 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Func copy$default(Func func, String str, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = func.name;
        }
        if ((i & 2) != 0) {
            map = func.params;
        }
        return func.copy(str, map);
    }

    public final String component1() {
        return this.name;
    }

    public final Map<String, Object> component2() {
        return this.params;
    }

    public final Func copy(String str, Map<String, ? extends Object> map) {
        return new Func(str, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Func) {
            Func func = (Func) obj;
            return Intrinsics.areEqual(this.name, func.name) && Intrinsics.areEqual(this.params, func.params);
        }
        return false;
    }

    public int hashCode() {
        return ((this.name == null ? 0 : this.name.hashCode()) * 31) + (this.params != null ? this.params.hashCode() : 0);
    }

    public String toString() {
        String str = this.name;
        return "Func(name=" + str + ", params=" + this.params + ")";
    }

    public Func(String name, Map<String, ? extends Object> map) {
        this.name = name;
        this.params = map;
    }

    public /* synthetic */ Func(String str, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : map);
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final Map<String, Object> getParams() {
        return this.params;
    }

    public final void setParams(Map<String, ? extends Object> map) {
        this.params = map;
    }
}