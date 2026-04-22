package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: Annotations.kt */
public final class FilteredAnnotations implements Annotations {
    private final Annotations delegate;
    private final Function1<FqName, Boolean> fqNameFilter;
    private final boolean isDefinitelyNewInference;

    /* JADX WARN: Multi-variable type inference failed */
    public FilteredAnnotations(Annotations delegate, boolean isDefinitelyNewInference, Function1<? super FqName, Boolean> fqNameFilter) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(fqNameFilter, "fqNameFilter");
        this.delegate = delegate;
        this.isDefinitelyNewInference = isDefinitelyNewInference;
        this.fqNameFilter = fqNameFilter;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FilteredAnnotations(Annotations delegate, Function1<? super FqName, Boolean> fqNameFilter) {
        this(delegate, false, fqNameFilter);
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(fqNameFilter, "fqNameFilter");
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean hasAnnotation(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        if (this.fqNameFilter.invoke(fqName).booleanValue()) {
            return this.delegate.hasAnnotation(fqName);
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    /* renamed from: findAnnotation */
    public AnnotationDescriptor mo1162findAnnotation(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        if (this.fqNameFilter.invoke(fqName).booleanValue()) {
            return this.delegate.mo1162findAnnotation(fqName);
        }
        return null;
    }

    @Override // java.lang.Iterable
    public Iterator<AnnotationDescriptor> iterator() {
        Iterable $this$filter$iv = this.delegate;
        Collection destination$iv$iv = new ArrayList();
        for (AnnotationDescriptor annotationDescriptor : $this$filter$iv) {
            AnnotationDescriptor p0 = annotationDescriptor;
            if (shouldBeReturned(p0)) {
                destination$iv$iv.add(annotationDescriptor);
            }
        }
        return ((List) destination$iv$iv).iterator();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean isEmpty() {
        boolean condition;
        Iterable $this$any$iv = this.delegate;
        if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
            Iterator<AnnotationDescriptor> it = $this$any$iv.iterator();
            while (true) {
                if (it.hasNext()) {
                    Object element$iv = it.next();
                    AnnotationDescriptor p0 = (AnnotationDescriptor) element$iv;
                    if (shouldBeReturned(p0)) {
                        condition = true;
                        break;
                    }
                } else {
                    condition = false;
                    break;
                }
            }
        } else {
            condition = false;
        }
        return this.isDefinitelyNewInference ? !condition : condition;
    }

    private final boolean shouldBeReturned(AnnotationDescriptor annotation) {
        FqName fqName = annotation.getFqName();
        return fqName != null && this.fqNameFilter.invoke(fqName).booleanValue();
    }
}