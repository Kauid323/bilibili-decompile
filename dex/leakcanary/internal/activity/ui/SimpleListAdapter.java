package leakcanary.internal.activity.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import leakcanary.internal.navigation.ViewsKt;

/* compiled from: SimpleListAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002BF\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012)\u0010\u0007\u001a%\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000b¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u0004H\u0016J\u0015\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\"\u0010\u0013\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R1\u0010\u0007\u001a%\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lleakcanary/internal/activity/ui/SimpleListAdapter;", "T", "Landroid/widget/BaseAdapter;", "rowResId", "", "items", "", "bindView", "Lkotlin/Function3;", "Landroid/view/View;", "", "Lkotlin/ExtensionFunctionType;", "(ILjava/util/List;Lkotlin/jvm/functions/Function3;)V", "getCount", "getItem", "position", "(I)Ljava/lang/Object;", "getItemId", "", "getView", "convertView", "parent", "Landroid/view/ViewGroup;", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class SimpleListAdapter<T> extends BaseAdapter {
    private final Function3<SimpleListAdapter<T>, View, Integer, Unit> bindView;
    private final List<T> items;
    private final int rowResId;

    /* JADX WARN: Multi-variable type inference failed */
    public SimpleListAdapter(int rowResId, List<? extends T> items, Function3<? super SimpleListAdapter<T>, ? super View, ? super Integer, Unit> bindView) {
        Intrinsics.checkParameterIsNotNull(items, "items");
        Intrinsics.checkParameterIsNotNull(bindView, "bindView");
        this.rowResId = rowResId;
        this.items = items;
        this.bindView = bindView;
    }

    @Override // android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        Intrinsics.checkParameterIsNotNull(parent, "parent");
        View view = convertView != null ? convertView : ViewsKt.inflate(parent, this.rowResId);
        this.bindView.invoke(this, view, Integer.valueOf(position));
        return view;
    }

    @Override // android.widget.Adapter
    public T getItem(int position) {
        return this.items.get(position);
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.items.size();
    }
}