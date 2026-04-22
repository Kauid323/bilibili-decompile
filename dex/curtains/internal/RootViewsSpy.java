package curtains.internal;

import android.view.View;
import curtains.OnRootViewsChangedListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RootViewsSpy.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000+\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0004\b\u0000\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fR\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcurtains/internal/RootViewsSpy;", "", "()V", "delegatingViewList", "curtains/internal/RootViewsSpy$delegatingViewList$1", "Lcurtains/internal/RootViewsSpy$delegatingViewList$1;", "listeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcurtains/OnRootViewsChangedListener;", "getListeners", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "copyRootViewList", "", "Landroid/view/View;", "Companion", "curtains_release"}, k = 1, mv = {1, 4, 1})
public final class RootViewsSpy {
    public static final Companion Companion = new Companion(null);
    private final RootViewsSpy$delegatingViewList$1 delegatingViewList;
    private final CopyOnWriteArrayList<OnRootViewsChangedListener> listeners;

    /* JADX WARN: Type inference failed for: r0v1, types: [curtains.internal.RootViewsSpy$delegatingViewList$1] */
    private RootViewsSpy() {
        this.listeners = new CopyOnWriteArrayList<>();
        this.delegatingViewList = new ArrayList<View>() { // from class: curtains.internal.RootViewsSpy$delegatingViewList$1
            public /* bridge */ boolean contains(View view) {
                return super.contains((Object) view);
            }

            @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
            public final /* bridge */ boolean contains(Object obj) {
                if (obj instanceof View) {
                    return contains((View) obj);
                }
                return false;
            }

            public /* bridge */ int getSize() {
                return super.size();
            }

            public /* bridge */ int indexOf(View view) {
                return super.indexOf((Object) view);
            }

            @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
            public final /* bridge */ int indexOf(Object obj) {
                if (obj instanceof View) {
                    return indexOf((View) obj);
                }
                return -1;
            }

            public /* bridge */ int lastIndexOf(View view) {
                return super.lastIndexOf((Object) view);
            }

            @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
            public final /* bridge */ int lastIndexOf(Object obj) {
                if (obj instanceof View) {
                    return lastIndexOf((View) obj);
                }
                return -1;
            }

            @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
            public final /* bridge */ View remove(int i2) {
                return remove(i2);
            }

            public /* bridge */ boolean remove(View view) {
                return super.remove((Object) view);
            }

            @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
            public final /* bridge */ boolean remove(Object obj) {
                if (obj instanceof View) {
                    return remove((View) obj);
                }
                return false;
            }

            @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
            public final /* bridge */ int size() {
                return getSize();
            }

            @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
            public boolean add(View element) {
                Intrinsics.checkNotNullParameter(element, "element");
                Iterable $this$forEach$iv = RootViewsSpy.this.getListeners();
                for (Object element$iv : $this$forEach$iv) {
                    OnRootViewsChangedListener it = (OnRootViewsChangedListener) element$iv;
                    it.onRootViewsChanged(element, true);
                }
                return super.add((RootViewsSpy$delegatingViewList$1) element);
            }

            @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
            /* renamed from: removeAt */
            public View remove(int index) {
                Object remove = super.remove(index);
                Intrinsics.checkNotNullExpressionValue(remove, "super.removeAt(index)");
                View removedView = (View) remove;
                Iterable $this$forEach$iv = RootViewsSpy.this.getListeners();
                for (Object element$iv : $this$forEach$iv) {
                    OnRootViewsChangedListener it = (OnRootViewsChangedListener) element$iv;
                    it.onRootViewsChanged(removedView, false);
                }
                return removedView;
            }
        };
    }

    public /* synthetic */ RootViewsSpy(DefaultConstructorMarker $constructor_marker) {
        this();
    }

    public final CopyOnWriteArrayList<OnRootViewsChangedListener> getListeners() {
        return this.listeners;
    }

    public final List<View> copyRootViewList() {
        return CollectionsKt.toList(this.delegatingViewList);
    }

    /* compiled from: RootViewsSpy.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcurtains/internal/RootViewsSpy$Companion;", "", "()V", "install", "Lcurtains/internal/RootViewsSpy;", "curtains_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public final RootViewsSpy install() {
            final RootViewsSpy $this$apply = new RootViewsSpy(null);
            WindowManagerSpy.INSTANCE.swapWindowManagerGlobalMViews(new Function1<ArrayList<View>, ArrayList<View>>() { // from class: curtains.internal.RootViewsSpy$Companion$install$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                public final ArrayList<View> invoke(ArrayList<View> arrayList) {
                    RootViewsSpy$delegatingViewList$1 $this$apply2;
                    Intrinsics.checkNotNullParameter(arrayList, "mViews");
                    $this$apply2 = RootViewsSpy.this.delegatingViewList;
                    $this$apply2.addAll(arrayList);
                    return $this$apply2;
                }
            });
            return $this$apply;
        }
    }
}