package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlinx.datetime.internal.DateCalculationsKt;
import leakcanary.internal.activity.db.LeaksDbHelper;

public class TypeParameterDescriptorImpl extends AbstractTypeParameterDescriptor {
    private boolean initialized;
    private final Function1<KotlinType, Void> reportCycleError;
    private final List<KotlinType> upperBounds;

    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str;
        int i2;
        switch (i) {
            case 5:
            case 28:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 5:
            case 28:
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 7:
            case additional_type_content_video_VALUE:
            case 20:
                objArr[0] = "annotations";
                break;
            case 2:
            case 8:
            case additional_type_content_comment_VALUE:
            case 21:
                objArr[0] = "variance";
                break;
            case 3:
            case 9:
            case 15:
            case 22:
                objArr[0] = "name";
                break;
            case 4:
            case 11:
            case 18:
            case LeaksDbHelper.VERSION /* 25 */:
                objArr[0] = "storageManager";
                break;
            case 5:
            case 28:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl";
                break;
            case 6:
            case additional_type_content_opus_VALUE:
            case 19:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 10:
            case 16:
            case 23:
                objArr[0] = "source";
                break;
            case 17:
                objArr[0] = "supertypeLoopsResolver";
                break;
            case DateCalculationsKt.HOURS_PER_DAY /* 24 */:
                objArr[0] = "supertypeLoopsChecker";
                break;
            case 26:
                objArr[0] = "bound";
                break;
            case 27:
                objArr[0] = "type";
                break;
        }
        switch (i) {
            case 5:
                objArr[1] = "createWithDefaultBound";
                break;
            case 28:
                objArr[1] = "resolveUpperBounds";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl";
                break;
        }
        switch (i) {
            case 5:
            case 28:
                break;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case additional_type_content_opus_VALUE:
            case additional_type_content_video_VALUE:
            case additional_type_content_comment_VALUE:
            case 15:
            case 16:
            case 17:
            case 18:
                objArr[2] = "createForFurtherModification";
                break;
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case DateCalculationsKt.HOURS_PER_DAY /* 24 */:
            case LeaksDbHelper.VERSION /* 25 */:
                objArr[2] = "<init>";
                break;
            case 26:
                objArr[2] = "addUpperBound";
                break;
            case 27:
                objArr[2] = "reportSupertypeLoopError";
                break;
            default:
                objArr[2] = "createWithDefaultBound";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case 5:
            case 28:
                throw new IllegalStateException(format);
            default:
                throw new IllegalArgumentException(format);
        }
    }

    public static TypeParameterDescriptor createWithDefaultBound(DeclarationDescriptor containingDeclaration, Annotations annotations, boolean reified, Variance variance, Name name, int index, StorageManager storageManager) {
        if (containingDeclaration == null) {
            $$$reportNull$$$0(0);
        }
        if (annotations == null) {
            $$$reportNull$$$0(1);
        }
        if (variance == null) {
            $$$reportNull$$$0(2);
        }
        if (name == null) {
            $$$reportNull$$$0(3);
        }
        if (storageManager == null) {
            $$$reportNull$$$0(4);
        }
        TypeParameterDescriptorImpl typeParameterDescriptor = createForFurtherModification(containingDeclaration, annotations, reified, variance, name, index, SourceElement.NO_SOURCE, storageManager);
        typeParameterDescriptor.addUpperBound(DescriptorUtilsKt.getBuiltIns(containingDeclaration).getDefaultBound());
        typeParameterDescriptor.setInitialized();
        if (typeParameterDescriptor == null) {
            $$$reportNull$$$0(5);
        }
        return typeParameterDescriptor;
    }

    public static TypeParameterDescriptorImpl createForFurtherModification(DeclarationDescriptor containingDeclaration, Annotations annotations, boolean reified, Variance variance, Name name, int index, SourceElement source, StorageManager storageManager) {
        if (containingDeclaration == null) {
            $$$reportNull$$$0(6);
        }
        if (annotations == null) {
            $$$reportNull$$$0(7);
        }
        if (variance == null) {
            $$$reportNull$$$0(8);
        }
        if (name == null) {
            $$$reportNull$$$0(9);
        }
        if (source == null) {
            $$$reportNull$$$0(10);
        }
        if (storageManager == null) {
            $$$reportNull$$$0(11);
        }
        return createForFurtherModification(containingDeclaration, annotations, reified, variance, name, index, source, null, SupertypeLoopChecker.EMPTY.INSTANCE, storageManager);
    }

    public static TypeParameterDescriptorImpl createForFurtherModification(DeclarationDescriptor containingDeclaration, Annotations annotations, boolean reified, Variance variance, Name name, int index, SourceElement source, Function1<KotlinType, Void> reportCycleError, SupertypeLoopChecker supertypeLoopsResolver, StorageManager storageManager) {
        if (containingDeclaration == null) {
            $$$reportNull$$$0(12);
        }
        if (annotations == null) {
            $$$reportNull$$$0(13);
        }
        if (variance == null) {
            $$$reportNull$$$0(14);
        }
        if (name == null) {
            $$$reportNull$$$0(15);
        }
        if (source == null) {
            $$$reportNull$$$0(16);
        }
        if (supertypeLoopsResolver == null) {
            $$$reportNull$$$0(17);
        }
        if (storageManager == null) {
            $$$reportNull$$$0(18);
        }
        return new TypeParameterDescriptorImpl(containingDeclaration, annotations, reified, variance, name, index, source, reportCycleError, supertypeLoopsResolver, storageManager);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private TypeParameterDescriptorImpl(DeclarationDescriptor containingDeclaration, Annotations annotations, boolean reified, Variance variance, Name name, int index, SourceElement source, Function1<KotlinType, Void> reportCycleError, SupertypeLoopChecker supertypeLoopsChecker, StorageManager storageManager) {
        super(storageManager, containingDeclaration, annotations, name, variance, reified, index, source, supertypeLoopsChecker);
        if (containingDeclaration == null) {
            $$$reportNull$$$0(19);
        }
        if (annotations == null) {
            $$$reportNull$$$0(20);
        }
        if (variance == null) {
            $$$reportNull$$$0(21);
        }
        if (name == null) {
            $$$reportNull$$$0(22);
        }
        if (source == null) {
            $$$reportNull$$$0(23);
        }
        if (supertypeLoopsChecker == null) {
            $$$reportNull$$$0(24);
        }
        if (storageManager == null) {
            $$$reportNull$$$0(25);
        }
        this.upperBounds = new ArrayList(1);
        this.initialized = false;
        this.reportCycleError = reportCycleError;
    }

    private void checkInitialized() {
        if (!this.initialized) {
            throw new IllegalStateException("Type parameter descriptor is not initialized: " + nameForAssertions());
        }
    }

    private void checkUninitialized() {
        if (this.initialized) {
            throw new IllegalStateException("Type parameter descriptor is already initialized: " + nameForAssertions());
        }
    }

    private String nameForAssertions() {
        return getName() + " declared in " + DescriptorUtils.getFqName(getContainingDeclaration());
    }

    public void setInitialized() {
        checkUninitialized();
        this.initialized = true;
    }

    public boolean isInitialized() {
        return this.initialized;
    }

    public void addUpperBound(KotlinType bound) {
        if (bound == null) {
            $$$reportNull$$$0(26);
        }
        checkUninitialized();
        doAddUpperBound(bound);
    }

    private void doAddUpperBound(KotlinType bound) {
        if (KotlinTypeKt.isError(bound)) {
            return;
        }
        this.upperBounds.add(bound);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeParameterDescriptor
    /* renamed from: reportSupertypeLoopError */
    protected void mo1174reportSupertypeLoopError(KotlinType type) {
        if (type == null) {
            $$$reportNull$$$0(27);
        }
        if (this.reportCycleError == null) {
            return;
        }
        this.reportCycleError.invoke(type);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeParameterDescriptor
    protected List<KotlinType> resolveUpperBounds() {
        checkInitialized();
        List<KotlinType> list = this.upperBounds;
        if (list == null) {
            $$$reportNull$$$0(28);
        }
        return list;
    }
}