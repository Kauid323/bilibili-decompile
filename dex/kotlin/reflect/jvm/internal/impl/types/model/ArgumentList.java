package kotlin.reflect.jvm.internal.impl.types.model;

import java.util.ArrayList;

/* compiled from: TypeSystemContext.kt */
public final class ArgumentList extends ArrayList<TypeArgumentMarker> implements TypeArgumentListMarker {
    public ArgumentList(int initialSize) {
        super(initialSize);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object element) {
        if (element instanceof TypeArgumentMarker) {
            return contains((TypeArgumentMarker) element);
        }
        return false;
    }

    public /* bridge */ boolean contains(TypeArgumentMarker p0) {
        return super.contains((Object) p0);
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object element) {
        if (element instanceof TypeArgumentMarker) {
            return indexOf((TypeArgumentMarker) element);
        }
        return -1;
    }

    public /* bridge */ int indexOf(TypeArgumentMarker p0) {
        return super.indexOf((Object) p0);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object element) {
        if (element instanceof TypeArgumentMarker) {
            return lastIndexOf((TypeArgumentMarker) element);
        }
        return -1;
    }

    public /* bridge */ int lastIndexOf(TypeArgumentMarker p0) {
        return super.lastIndexOf((Object) p0);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean remove(Object element) {
        if (element instanceof TypeArgumentMarker) {
            return remove((TypeArgumentMarker) element);
        }
        return false;
    }

    public /* bridge */ boolean remove(TypeArgumentMarker p0) {
        return super.remove((Object) p0);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }
}