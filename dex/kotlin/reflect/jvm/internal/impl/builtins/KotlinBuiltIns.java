package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.builtins.functions.BuiltInFictitiousFunctionClassFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import kotlinx.coroutines.scheduling.WorkQueueKt;
import kotlinx.datetime.internal.DateCalculationsKt;
import leakcanary.internal.activity.db.LeaksDbHelper;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.codec.binary.BaseNCodec;
import org.java_websocket.WebSocketImpl;
import org.webrtc.H265Utils;

public abstract class KotlinBuiltIns {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final Name BUILTINS_MODULE_NAME = Name.special("<built-ins module>");
    private final MemoizedFunctionToNotNull<Name, ClassDescriptor> builtInClassesByName;
    private final NotNullLazyValue<Collection<PackageViewDescriptor>> builtInPackagesImportedByDefault;
    private ModuleDescriptorImpl builtInsModule;
    private NotNullLazyValue<ModuleDescriptorImpl> postponedBuiltInsModule;
    private final NotNullLazyValue<Primitives> primitives;
    private final StorageManager storageManager;

    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str;
        int i2;
        switch (i) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case additional_type_content_video_VALUE:
            case 15:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case DateCalculationsKt.HOURS_PER_DAY /* 24 */:
            case LeaksDbHelper.VERSION /* 25 */:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
            case 62:
            case H265Utils.kLevel2_1 /* 63 */:
            case 64:
            case 65:
            case 66:
            case 67:
            case 69:
            case HelpFormatter.DEFAULT_WIDTH /* 74 */:
            case 81:
            case 84:
            case 86:
            case 87:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 9:
            case 10:
            case additional_type_content_opus_VALUE:
            case additional_type_content_comment_VALUE:
            case 16:
            case 17:
            case 47:
            case 54:
            case 68:
            case 70:
            case 71:
            case 72:
            case 73:
            case 75:
            case BaseNCodec.MIME_CHUNK_SIZE /* 76 */:
            case 77:
            case 78:
            case 79:
            case WebSocketImpl.DEFAULT_PORT /* 80 */:
            case 82:
            case 83:
            case 85:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case additional_type_content_video_VALUE:
            case 15:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case DateCalculationsKt.HOURS_PER_DAY /* 24 */:
            case LeaksDbHelper.VERSION /* 25 */:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
            case 62:
            case H265Utils.kLevel2_1 /* 63 */:
            case 64:
            case 65:
            case 66:
            case 67:
            case 69:
            case HelpFormatter.DEFAULT_WIDTH /* 74 */:
            case 81:
            case 84:
            case 86:
            case 87:
                i2 = 2;
                break;
            case 9:
            case 10:
            case additional_type_content_opus_VALUE:
            case additional_type_content_comment_VALUE:
            case 16:
            case 17:
            case 47:
            case 54:
            case 68:
            case 70:
            case 71:
            case 72:
            case 73:
            case 75:
            case BaseNCodec.MIME_CHUNK_SIZE /* 76 */:
            case 77:
            case 78:
            case 79:
            case WebSocketImpl.DEFAULT_PORT /* 80 */:
            case 82:
            case 83:
            case 85:
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 72:
                objArr[0] = "module";
                break;
            case 2:
                objArr[0] = "computation";
                break;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case additional_type_content_video_VALUE:
            case 15:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case DateCalculationsKt.HOURS_PER_DAY /* 24 */:
            case LeaksDbHelper.VERSION /* 25 */:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
            case 62:
            case H265Utils.kLevel2_1 /* 63 */:
            case 64:
            case 65:
            case 66:
            case 67:
            case 69:
            case HelpFormatter.DEFAULT_WIDTH /* 74 */:
            case 81:
            case 84:
            case 86:
            case 87:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns";
                break;
            case 9:
            case 10:
            case BaseNCodec.MIME_CHUNK_SIZE /* 76 */:
            case 77:
            case 89:
            case 96:
            case 103:
            case 107:
            case 108:
            case 143:
            case 146:
            case 147:
            case 149:
            case 157:
            case 158:
            case 159:
                objArr[0] = "descriptor";
                break;
            case additional_type_content_opus_VALUE:
            case 98:
            case 100:
            case 102:
            case 104:
            case 106:
            case 135:
                objArr[0] = "fqName";
                break;
            case additional_type_content_comment_VALUE:
                objArr[0] = "simpleName";
                break;
            case 16:
            case 17:
            case 54:
            case 88:
            case H265Utils.kLevel3 /* 90 */:
            case 91:
            case 92:
            case H265Utils.kLevel3_1 /* 93 */:
            case 94:
            case 95:
            case 97:
            case 99:
            case 105:
            case 109:
            case 110:
            case 111:
            case 113:
            case 114:
            case 115:
            case 116:
            case 117:
            case 118:
            case 119:
            case H265Utils.kLevel4 /* 120 */:
            case 121:
            case 122:
            case H265Utils.kLevel4_1 /* 123 */:
            case 124:
            case 125:
            case 126:
            case WorkQueueKt.MASK /* 127 */:
            case 128:
            case 129:
            case 130:
            case 131:
            case 132:
            case 133:
            case 134:
            case 136:
            case 137:
            case 138:
            case 139:
            case 140:
            case 141:
            case 142:
            case 144:
            case 145:
            case 148:
            case H265Utils.kLevel5 /* 150 */:
            case 151:
            case 152:
            case H265Utils.kLevel5_1 /* 153 */:
            case 154:
            case 155:
            case H265Utils.kLevel5_2 /* 156 */:
            case 161:
                objArr[0] = "type";
                break;
            case 47:
                objArr[0] = "classSimpleName";
                break;
            case 68:
            case 70:
                objArr[0] = "arrayType";
                break;
            case 71:
                objArr[0] = "notNullArrayType";
                break;
            case 73:
                objArr[0] = "primitiveType";
                break;
            case 75:
                objArr[0] = "kotlinType";
                break;
            case 78:
            case 82:
                objArr[0] = "projectionType";
                break;
            case 79:
            case 83:
            case 85:
                objArr[0] = "argument";
                break;
            case WebSocketImpl.DEFAULT_PORT /* 80 */:
                objArr[0] = "annotations";
                break;
            case 101:
                objArr[0] = "typeConstructor";
                break;
            case 112:
                objArr[0] = "classDescriptor";
                break;
            case 160:
                objArr[0] = "declarationDescriptor";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        switch (i) {
            case 3:
                objArr[1] = "getAdditionalClassPartsProvider";
                break;
            case 4:
                objArr[1] = "getPlatformDependentDeclarationFilter";
                break;
            case 5:
                objArr[1] = "getClassDescriptorFactories";
                break;
            case 6:
                objArr[1] = "getStorageManager";
                break;
            case 7:
                objArr[1] = "getBuiltInsModule";
                break;
            case 8:
                objArr[1] = "getBuiltInPackagesImportedByDefault";
                break;
            case 9:
            case 10:
            case additional_type_content_opus_VALUE:
            case additional_type_content_comment_VALUE:
            case 16:
            case 17:
            case 47:
            case 54:
            case 68:
            case 70:
            case 71:
            case 72:
            case 73:
            case 75:
            case BaseNCodec.MIME_CHUNK_SIZE /* 76 */:
            case 77:
            case 78:
            case 79:
            case WebSocketImpl.DEFAULT_PORT /* 80 */:
            case 82:
            case 83:
            case 85:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns";
                break;
            case 11:
                objArr[1] = "getBuiltInsPackageScope";
                break;
            case additional_type_content_video_VALUE:
                objArr[1] = "getBuiltInClassByFqName";
                break;
            case 15:
                objArr[1] = "getBuiltInClassByName";
                break;
            case 18:
                objArr[1] = "getSuspendFunction";
                break;
            case 19:
                objArr[1] = "getKFunction";
                break;
            case 20:
                objArr[1] = "getKSuspendFunction";
                break;
            case 21:
                objArr[1] = "getKClass";
                break;
            case 22:
                objArr[1] = "getKType";
                break;
            case 23:
                objArr[1] = "getKCallable";
                break;
            case DateCalculationsKt.HOURS_PER_DAY /* 24 */:
                objArr[1] = "getKProperty";
                break;
            case LeaksDbHelper.VERSION /* 25 */:
                objArr[1] = "getKProperty0";
                break;
            case 26:
                objArr[1] = "getKProperty1";
                break;
            case 27:
                objArr[1] = "getKProperty2";
                break;
            case 28:
                objArr[1] = "getKMutableProperty0";
                break;
            case 29:
                objArr[1] = "getKMutableProperty1";
                break;
            case 30:
                objArr[1] = "getKMutableProperty2";
                break;
            case 31:
                objArr[1] = "getIterator";
                break;
            case 32:
                objArr[1] = "getIterable";
                break;
            case 33:
                objArr[1] = "getMutableIterable";
                break;
            case 34:
                objArr[1] = "getMutableIterator";
                break;
            case 35:
                objArr[1] = "getCollection";
                break;
            case 36:
                objArr[1] = "getMutableCollection";
                break;
            case 37:
                objArr[1] = "getList";
                break;
            case 38:
                objArr[1] = "getMutableList";
                break;
            case 39:
                objArr[1] = "getSet";
                break;
            case 40:
                objArr[1] = "getMutableSet";
                break;
            case 41:
                objArr[1] = "getMap";
                break;
            case 42:
                objArr[1] = "getMutableMap";
                break;
            case 43:
                objArr[1] = "getMapEntry";
                break;
            case 44:
                objArr[1] = "getMutableMapEntry";
                break;
            case 45:
                objArr[1] = "getListIterator";
                break;
            case 46:
                objArr[1] = "getMutableListIterator";
                break;
            case 48:
                objArr[1] = "getBuiltInTypeByClassName";
                break;
            case 49:
                objArr[1] = "getNothingType";
                break;
            case 50:
                objArr[1] = "getNullableNothingType";
                break;
            case 51:
                objArr[1] = "getAnyType";
                break;
            case 52:
                objArr[1] = "getNullableAnyType";
                break;
            case 53:
                objArr[1] = "getDefaultBound";
                break;
            case 55:
                objArr[1] = "getPrimitiveKotlinType";
                break;
            case 56:
                objArr[1] = "getNumberType";
                break;
            case 57:
                objArr[1] = "getByteType";
                break;
            case 58:
                objArr[1] = "getShortType";
                break;
            case 59:
                objArr[1] = "getIntType";
                break;
            case 60:
                objArr[1] = "getLongType";
                break;
            case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                objArr[1] = "getFloatType";
                break;
            case 62:
                objArr[1] = "getDoubleType";
                break;
            case H265Utils.kLevel2_1 /* 63 */:
                objArr[1] = "getCharType";
                break;
            case 64:
                objArr[1] = "getBooleanType";
                break;
            case 65:
                objArr[1] = "getUnitType";
                break;
            case 66:
                objArr[1] = "getStringType";
                break;
            case 67:
                objArr[1] = "getIterableType";
                break;
            case 69:
                objArr[1] = "getArrayElementType";
                break;
            case HelpFormatter.DEFAULT_WIDTH /* 74 */:
                objArr[1] = "getPrimitiveArrayKotlinType";
                break;
            case 81:
            case 84:
                objArr[1] = "getArrayType";
                break;
            case 86:
                objArr[1] = "getEnumType";
                break;
            case 87:
                objArr[1] = "getAnnotationType";
                break;
        }
        switch (i) {
            case 1:
                objArr[2] = "setBuiltInsModule";
                break;
            case 2:
                objArr[2] = "setPostponedBuiltinsModuleComputation";
                break;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case additional_type_content_video_VALUE:
            case 15:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case DateCalculationsKt.HOURS_PER_DAY /* 24 */:
            case LeaksDbHelper.VERSION /* 25 */:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
            case 62:
            case H265Utils.kLevel2_1 /* 63 */:
            case 64:
            case 65:
            case 66:
            case 67:
            case 69:
            case HelpFormatter.DEFAULT_WIDTH /* 74 */:
            case 81:
            case 84:
            case 86:
            case 87:
                break;
            case 9:
                objArr[2] = "isBuiltIn";
                break;
            case 10:
                objArr[2] = "isUnderKotlinPackage";
                break;
            case additional_type_content_opus_VALUE:
                objArr[2] = "getBuiltInClassByFqName";
                break;
            case additional_type_content_comment_VALUE:
                objArr[2] = "getBuiltInClassByName";
                break;
            case 16:
                objArr[2] = "getPrimitiveClassDescriptor";
                break;
            case 17:
                objArr[2] = "getPrimitiveArrayClassDescriptor";
                break;
            case 47:
                objArr[2] = "getBuiltInTypeByClassName";
                break;
            case 54:
                objArr[2] = "getPrimitiveKotlinType";
                break;
            case 68:
                objArr[2] = "getArrayElementType";
                break;
            case 70:
                objArr[2] = "getArrayElementTypeOrNull";
                break;
            case 71:
            case 72:
                objArr[2] = "getElementTypeForUnsignedArray";
                break;
            case 73:
                objArr[2] = "getPrimitiveArrayKotlinType";
                break;
            case 75:
                objArr[2] = "getPrimitiveArrayKotlinTypeByPrimitiveKotlinType";
                break;
            case BaseNCodec.MIME_CHUNK_SIZE /* 76 */:
            case H265Utils.kLevel3_1 /* 93 */:
                objArr[2] = "getPrimitiveType";
                break;
            case 77:
                objArr[2] = "getPrimitiveArrayType";
                break;
            case 78:
            case 79:
            case WebSocketImpl.DEFAULT_PORT /* 80 */:
            case 82:
            case 83:
                objArr[2] = "getArrayType";
                break;
            case 85:
                objArr[2] = "getEnumType";
                break;
            case 88:
                objArr[2] = "isArray";
                break;
            case 89:
            case H265Utils.kLevel3 /* 90 */:
                objArr[2] = "isArrayOrPrimitiveArray";
                break;
            case 91:
                objArr[2] = "isPrimitiveArray";
                break;
            case 92:
                objArr[2] = "getPrimitiveArrayElementType";
                break;
            case 94:
                objArr[2] = "isPrimitiveType";
                break;
            case 95:
                objArr[2] = "isPrimitiveTypeOrNullablePrimitiveType";
                break;
            case 96:
                objArr[2] = "isPrimitiveClass";
                break;
            case 97:
            case 98:
            case 99:
            case 100:
                objArr[2] = "isConstructedFromGivenClass";
                break;
            case 101:
            case 102:
                objArr[2] = "isTypeConstructorForGivenClass";
                break;
            case 103:
            case 104:
                objArr[2] = "classFqNameEquals";
                break;
            case 105:
            case 106:
                objArr[2] = "isNotNullConstructedFromGivenClass";
                break;
            case 107:
                objArr[2] = "isSpecialClassWithNoSupertypes";
                break;
            case 108:
            case 109:
                objArr[2] = "isAny";
                break;
            case 110:
            case 112:
                objArr[2] = "isBoolean";
                break;
            case 111:
                objArr[2] = "isBooleanOrNullableBoolean";
                break;
            case 113:
                objArr[2] = "isNumber";
                break;
            case 114:
                objArr[2] = "isChar";
                break;
            case 115:
                objArr[2] = "isCharOrNullableChar";
                break;
            case 116:
                objArr[2] = "isInt";
                break;
            case 117:
                objArr[2] = "isByte";
                break;
            case 118:
                objArr[2] = "isLong";
                break;
            case 119:
                objArr[2] = "isLongOrNullableLong";
                break;
            case H265Utils.kLevel4 /* 120 */:
                objArr[2] = "isShort";
                break;
            case 121:
                objArr[2] = "isFloat";
                break;
            case 122:
                objArr[2] = "isFloatOrNullableFloat";
                break;
            case H265Utils.kLevel4_1 /* 123 */:
                objArr[2] = "isDouble";
                break;
            case 124:
                objArr[2] = "isUByte";
                break;
            case 125:
                objArr[2] = "isUShort";
                break;
            case 126:
                objArr[2] = "isUInt";
                break;
            case WorkQueueKt.MASK /* 127 */:
                objArr[2] = "isULong";
                break;
            case 128:
                objArr[2] = "isUByteArray";
                break;
            case 129:
                objArr[2] = "isUShortArray";
                break;
            case 130:
                objArr[2] = "isUIntArray";
                break;
            case 131:
                objArr[2] = "isULongArray";
                break;
            case 132:
                objArr[2] = "isUnsignedArrayType";
                break;
            case 133:
                objArr[2] = "isDoubleOrNullableDouble";
                break;
            case 134:
            case 135:
                objArr[2] = "isConstructedFromGivenClassAndNotNullable";
                break;
            case 136:
                objArr[2] = "isNothing";
                break;
            case 137:
                objArr[2] = "isNullableNothing";
                break;
            case 138:
                objArr[2] = "isNothingOrNullableNothing";
                break;
            case 139:
                objArr[2] = "isAnyOrNullableAny";
                break;
            case 140:
                objArr[2] = "isNullableAny";
                break;
            case 141:
                objArr[2] = "isDefaultBound";
                break;
            case 142:
                objArr[2] = "isUnit";
                break;
            case 143:
                objArr[2] = "mayReturnNonUnitValue";
                break;
            case 144:
                objArr[2] = "isUnitOrNullableUnit";
                break;
            case 145:
                objArr[2] = "isBooleanOrSubtype";
                break;
            case 146:
                objArr[2] = "isMemberOfAny";
                break;
            case 147:
            case 148:
                objArr[2] = "isEnum";
                break;
            case 149:
            case H265Utils.kLevel5 /* 150 */:
                objArr[2] = "isComparable";
                break;
            case 151:
                objArr[2] = "isCollectionOrNullableCollection";
                break;
            case 152:
                objArr[2] = "isListOrNullableList";
                break;
            case H265Utils.kLevel5_1 /* 153 */:
                objArr[2] = "isSetOrNullableSet";
                break;
            case 154:
                objArr[2] = "isMapOrNullableMap";
                break;
            case 155:
                objArr[2] = "isIterableOrNullableIterable";
                break;
            case H265Utils.kLevel5_2 /* 156 */:
                objArr[2] = "isThrowableOrNullableThrowable";
                break;
            case 157:
                objArr[2] = "isThrowable";
                break;
            case 158:
                objArr[2] = "isKClass";
                break;
            case 159:
                objArr[2] = "isNonPrimitiveArray";
                break;
            case 160:
                objArr[2] = "isDeprecated";
                break;
            case 161:
                objArr[2] = "isNotNullOrNullableFunctionSupertype";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case additional_type_content_video_VALUE:
            case 15:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case DateCalculationsKt.HOURS_PER_DAY /* 24 */:
            case LeaksDbHelper.VERSION /* 25 */:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
            case 62:
            case H265Utils.kLevel2_1 /* 63 */:
            case 64:
            case 65:
            case 66:
            case 67:
            case 69:
            case HelpFormatter.DEFAULT_WIDTH /* 74 */:
            case 81:
            case 84:
            case 86:
            case 87:
                throw new IllegalStateException(format);
            case 9:
            case 10:
            case additional_type_content_opus_VALUE:
            case additional_type_content_comment_VALUE:
            case 16:
            case 17:
            case 47:
            case 54:
            case 68:
            case 70:
            case 71:
            case 72:
            case 73:
            case 75:
            case BaseNCodec.MIME_CHUNK_SIZE /* 76 */:
            case 77:
            case 78:
            case 79:
            case WebSocketImpl.DEFAULT_PORT /* 80 */:
            case 82:
            case 83:
            case 85:
            default:
                throw new IllegalArgumentException(format);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public KotlinBuiltIns(StorageManager storageManager) {
        if (storageManager == null) {
            $$$reportNull$$$0(0);
        }
        this.storageManager = storageManager;
        this.builtInPackagesImportedByDefault = storageManager.createLazyValue(new Function0<Collection<PackageViewDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.1
            @Override // kotlin.jvm.functions.Function0
            public Collection<PackageViewDescriptor> invoke() {
                return Arrays.asList(KotlinBuiltIns.this.getBuiltInsModule().getPackage(StandardNames.BUILT_INS_PACKAGE_FQ_NAME), KotlinBuiltIns.this.getBuiltInsModule().getPackage(StandardNames.COLLECTIONS_PACKAGE_FQ_NAME), KotlinBuiltIns.this.getBuiltInsModule().getPackage(StandardNames.RANGES_PACKAGE_FQ_NAME), KotlinBuiltIns.this.getBuiltInsModule().getPackage(StandardNames.ANNOTATION_PACKAGE_FQ_NAME));
            }
        });
        this.primitives = storageManager.createLazyValue(new Function0<Primitives>() { // from class: kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.2
            @Override // kotlin.jvm.functions.Function0
            public Primitives invoke() {
                PrimitiveType[] values;
                Map<PrimitiveType, SimpleType> primitiveTypeToArrayKotlinType = new EnumMap<>(PrimitiveType.class);
                Map<KotlinType, SimpleType> primitiveKotlinTypeToKotlinArrayType = new HashMap<>();
                Map<SimpleType, SimpleType> kotlinArrayTypeToPrimitiveKotlinType = new HashMap<>();
                for (PrimitiveType primitive : PrimitiveType.values()) {
                    SimpleType type = KotlinBuiltIns.this.getBuiltInTypeByClassName(primitive.getTypeName().asString());
                    SimpleType arrayType = KotlinBuiltIns.this.getBuiltInTypeByClassName(primitive.getArrayTypeName().asString());
                    primitiveTypeToArrayKotlinType.put(primitive, arrayType);
                    primitiveKotlinTypeToKotlinArrayType.put(type, arrayType);
                    kotlinArrayTypeToPrimitiveKotlinType.put(arrayType, type);
                }
                return new Primitives(primitiveTypeToArrayKotlinType, primitiveKotlinTypeToKotlinArrayType, kotlinArrayTypeToPrimitiveKotlinType);
            }
        });
        this.builtInClassesByName = storageManager.createMemoizedFunction(new Function1<Name, ClassDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.3
            @Override // kotlin.jvm.functions.Function1
            public ClassDescriptor invoke(Name name) {
                ClassifierDescriptor classifier = KotlinBuiltIns.this.getBuiltInsPackageScope().mo1173getContributedClassifier(name, NoLookupLocation.FROM_BUILTINS);
                if (classifier == null) {
                    throw new AssertionError("Built-in class " + StandardNames.BUILT_INS_PACKAGE_FQ_NAME.child(name) + " is not found");
                }
                if (!(classifier instanceof ClassDescriptor)) {
                    throw new AssertionError("Must be a class descriptor " + name + ", but was " + classifier);
                }
                return (ClassDescriptor) classifier;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void createBuiltInsModule(boolean isFallback) {
        this.builtInsModule = new ModuleDescriptorImpl(BUILTINS_MODULE_NAME, this.storageManager, this, null);
        this.builtInsModule.initialize(BuiltInsLoader.Companion.getInstance().createPackageFragmentProvider(this.storageManager, this.builtInsModule, getClassDescriptorFactories(), getPlatformDependentDeclarationFilter(), getAdditionalClassPartsProvider(), isFallback));
        this.builtInsModule.setDependencies(this.builtInsModule);
    }

    public void setBuiltInsModule(final ModuleDescriptorImpl module) {
        if (module == null) {
            $$$reportNull$$$0(1);
        }
        this.storageManager.compute(new Function0<Void>() { // from class: kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.4
            @Override // kotlin.jvm.functions.Function0
            public Void invoke() {
                if (KotlinBuiltIns.this.builtInsModule != null) {
                    throw new AssertionError("Built-ins module is already set: " + KotlinBuiltIns.this.builtInsModule + " (attempting to reset to " + module + ")");
                }
                KotlinBuiltIns.this.builtInsModule = module;
                return null;
            }
        });
    }

    protected AdditionalClassPartsProvider getAdditionalClassPartsProvider() {
        AdditionalClassPartsProvider.None none = AdditionalClassPartsProvider.None.INSTANCE;
        if (none == null) {
            $$$reportNull$$$0(3);
        }
        return none;
    }

    protected PlatformDependentDeclarationFilter getPlatformDependentDeclarationFilter() {
        PlatformDependentDeclarationFilter.NoPlatformDependent noPlatformDependent = PlatformDependentDeclarationFilter.NoPlatformDependent.INSTANCE;
        if (noPlatformDependent == null) {
            $$$reportNull$$$0(4);
        }
        return noPlatformDependent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Iterable<ClassDescriptorFactory> getClassDescriptorFactories() {
        List singletonList = Collections.singletonList(new BuiltInFictitiousFunctionClassFactory(this.storageManager, getBuiltInsModule()));
        if (singletonList == null) {
            $$$reportNull$$$0(5);
        }
        return singletonList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public StorageManager getStorageManager() {
        StorageManager storageManager = this.storageManager;
        if (storageManager == null) {
            $$$reportNull$$$0(6);
        }
        return storageManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static class Primitives {
        public final Map<SimpleType, SimpleType> kotlinArrayTypeToPrimitiveKotlinType;
        public final Map<KotlinType, SimpleType> primitiveKotlinTypeToKotlinArrayType;
        public final Map<PrimitiveType, SimpleType> primitiveTypeToArrayKotlinType;

        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            Object[] objArr = new Object[3];
            switch (i) {
                case 1:
                    objArr[0] = "primitiveKotlinTypeToKotlinArrayType";
                    break;
                case 2:
                    objArr[0] = "kotlinArrayTypeToPrimitiveKotlinType";
                    break;
                default:
                    objArr[0] = "primitiveTypeToArrayKotlinType";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns$Primitives";
            objArr[2] = "<init>";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        private Primitives(Map<PrimitiveType, SimpleType> primitiveTypeToArrayKotlinType, Map<KotlinType, SimpleType> primitiveKotlinTypeToKotlinArrayType, Map<SimpleType, SimpleType> kotlinArrayTypeToPrimitiveKotlinType) {
            if (primitiveTypeToArrayKotlinType == null) {
                $$$reportNull$$$0(0);
            }
            if (primitiveKotlinTypeToKotlinArrayType == null) {
                $$$reportNull$$$0(1);
            }
            if (kotlinArrayTypeToPrimitiveKotlinType == null) {
                $$$reportNull$$$0(2);
            }
            this.primitiveTypeToArrayKotlinType = primitiveTypeToArrayKotlinType;
            this.primitiveKotlinTypeToKotlinArrayType = primitiveKotlinTypeToKotlinArrayType;
            this.kotlinArrayTypeToPrimitiveKotlinType = kotlinArrayTypeToPrimitiveKotlinType;
        }
    }

    public ModuleDescriptorImpl getBuiltInsModule() {
        if (this.builtInsModule == null && this.postponedBuiltInsModule == null) {
            throw new AssertionError("Uninitialized built-ins module");
        }
        if (this.builtInsModule == null) {
            this.builtInsModule = this.postponedBuiltInsModule.invoke();
        }
        ModuleDescriptorImpl moduleDescriptorImpl = this.builtInsModule;
        if (moduleDescriptorImpl == null) {
            $$$reportNull$$$0(7);
        }
        return moduleDescriptorImpl;
    }

    public static boolean isBuiltIn(DeclarationDescriptor descriptor) {
        if (descriptor == null) {
            $$$reportNull$$$0(9);
        }
        return DescriptorUtils.getParentOfType(descriptor, BuiltInsPackageFragment.class, false) != null;
    }

    public static boolean isUnderKotlinPackage(DeclarationDescriptor descriptor) {
        if (descriptor == null) {
            $$$reportNull$$$0(10);
        }
        for (DeclarationDescriptor current = descriptor; current != null; current = current.getContainingDeclaration()) {
            if (current instanceof PackageFragmentDescriptor) {
                return ((PackageFragmentDescriptor) current).getFqName().startsWith(StandardNames.BUILT_INS_PACKAGE_NAME);
            }
        }
        return false;
    }

    public MemberScope getBuiltInsPackageScope() {
        MemberScope memberScope = getBuiltInsModule().getPackage(StandardNames.BUILT_INS_PACKAGE_FQ_NAME).getMemberScope();
        if (memberScope == null) {
            $$$reportNull$$$0(11);
        }
        return memberScope;
    }

    public ClassDescriptor getBuiltInClassByFqName(FqName fqName) {
        if (fqName == null) {
            $$$reportNull$$$0(12);
        }
        ClassDescriptor descriptor = DescriptorUtilKt.resolveClassByFqName(getBuiltInsModule(), fqName, NoLookupLocation.FROM_BUILTINS);
        if (descriptor == null) {
            throw new AssertionError("Can't find built-in class " + fqName);
        }
        if (descriptor == null) {
            $$$reportNull$$$0(13);
        }
        return descriptor;
    }

    private ClassDescriptor getBuiltInClassByName(String simpleName) {
        if (simpleName == null) {
            $$$reportNull$$$0(14);
        }
        ClassDescriptor invoke = this.builtInClassesByName.invoke(Name.identifier(simpleName));
        if (invoke == null) {
            $$$reportNull$$$0(15);
        }
        return invoke;
    }

    public ClassDescriptor getAny() {
        return getBuiltInClassByName("Any");
    }

    public ClassDescriptor getNothing() {
        return getBuiltInClassByName("Nothing");
    }

    private ClassDescriptor getPrimitiveClassDescriptor(PrimitiveType type) {
        if (type == null) {
            $$$reportNull$$$0(16);
        }
        return getBuiltInClassByName(type.getTypeName().asString());
    }

    public ClassDescriptor getArray() {
        return getBuiltInClassByName("Array");
    }

    public ClassDescriptor getNumber() {
        return getBuiltInClassByName("Number");
    }

    public ClassDescriptor getUnit() {
        return getBuiltInClassByName("Unit");
    }

    public ClassDescriptor getFunction(int parameterCount) {
        return getBuiltInClassByName(StandardNames.getFunctionName(parameterCount));
    }

    public ClassDescriptor getSuspendFunction(int parameterCount) {
        ClassDescriptor builtInClassByFqName = getBuiltInClassByFqName(StandardNames.COROUTINES_PACKAGE_FQ_NAME.child(Name.identifier(StandardNames.getSuspendFunctionName(parameterCount))));
        if (builtInClassByFqName == null) {
            $$$reportNull$$$0(18);
        }
        return builtInClassByFqName;
    }

    public ClassDescriptor getString() {
        return getBuiltInClassByName("String");
    }

    public ClassDescriptor getComparable() {
        return getBuiltInClassByName("Comparable");
    }

    public ClassDescriptor getKClass() {
        ClassDescriptor builtInClassByFqName = getBuiltInClassByFqName(StandardNames.FqNames.kClass.toSafe());
        if (builtInClassByFqName == null) {
            $$$reportNull$$$0(21);
        }
        return builtInClassByFqName;
    }

    public ClassDescriptor getCollection() {
        ClassDescriptor builtInClassByFqName = getBuiltInClassByFqName(StandardNames.FqNames.collection);
        if (builtInClassByFqName == null) {
            $$$reportNull$$$0(35);
        }
        return builtInClassByFqName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SimpleType getBuiltInTypeByClassName(String classSimpleName) {
        if (classSimpleName == null) {
            $$$reportNull$$$0(47);
        }
        SimpleType defaultType = getBuiltInClassByName(classSimpleName).getDefaultType();
        if (defaultType == null) {
            $$$reportNull$$$0(48);
        }
        return defaultType;
    }

    public SimpleType getNothingType() {
        SimpleType defaultType = getNothing().getDefaultType();
        if (defaultType == null) {
            $$$reportNull$$$0(49);
        }
        return defaultType;
    }

    public SimpleType getNullableNothingType() {
        SimpleType makeNullableAsSpecified = getNothingType().makeNullableAsSpecified(true);
        if (makeNullableAsSpecified == null) {
            $$$reportNull$$$0(50);
        }
        return makeNullableAsSpecified;
    }

    public SimpleType getAnyType() {
        SimpleType defaultType = getAny().getDefaultType();
        if (defaultType == null) {
            $$$reportNull$$$0(51);
        }
        return defaultType;
    }

    public SimpleType getNullableAnyType() {
        SimpleType makeNullableAsSpecified = getAnyType().makeNullableAsSpecified(true);
        if (makeNullableAsSpecified == null) {
            $$$reportNull$$$0(52);
        }
        return makeNullableAsSpecified;
    }

    public SimpleType getDefaultBound() {
        SimpleType nullableAnyType = getNullableAnyType();
        if (nullableAnyType == null) {
            $$$reportNull$$$0(53);
        }
        return nullableAnyType;
    }

    public SimpleType getPrimitiveKotlinType(PrimitiveType type) {
        if (type == null) {
            $$$reportNull$$$0(54);
        }
        SimpleType defaultType = getPrimitiveClassDescriptor(type).getDefaultType();
        if (defaultType == null) {
            $$$reportNull$$$0(55);
        }
        return defaultType;
    }

    public SimpleType getNumberType() {
        SimpleType defaultType = getNumber().getDefaultType();
        if (defaultType == null) {
            $$$reportNull$$$0(56);
        }
        return defaultType;
    }

    public SimpleType getByteType() {
        SimpleType primitiveKotlinType = getPrimitiveKotlinType(PrimitiveType.BYTE);
        if (primitiveKotlinType == null) {
            $$$reportNull$$$0(57);
        }
        return primitiveKotlinType;
    }

    public SimpleType getShortType() {
        SimpleType primitiveKotlinType = getPrimitiveKotlinType(PrimitiveType.SHORT);
        if (primitiveKotlinType == null) {
            $$$reportNull$$$0(58);
        }
        return primitiveKotlinType;
    }

    public SimpleType getIntType() {
        SimpleType primitiveKotlinType = getPrimitiveKotlinType(PrimitiveType.INT);
        if (primitiveKotlinType == null) {
            $$$reportNull$$$0(59);
        }
        return primitiveKotlinType;
    }

    public SimpleType getLongType() {
        SimpleType primitiveKotlinType = getPrimitiveKotlinType(PrimitiveType.LONG);
        if (primitiveKotlinType == null) {
            $$$reportNull$$$0(60);
        }
        return primitiveKotlinType;
    }

    public SimpleType getFloatType() {
        SimpleType primitiveKotlinType = getPrimitiveKotlinType(PrimitiveType.FLOAT);
        if (primitiveKotlinType == null) {
            $$$reportNull$$$0(61);
        }
        return primitiveKotlinType;
    }

    public SimpleType getDoubleType() {
        SimpleType primitiveKotlinType = getPrimitiveKotlinType(PrimitiveType.DOUBLE);
        if (primitiveKotlinType == null) {
            $$$reportNull$$$0(62);
        }
        return primitiveKotlinType;
    }

    public SimpleType getCharType() {
        SimpleType primitiveKotlinType = getPrimitiveKotlinType(PrimitiveType.CHAR);
        if (primitiveKotlinType == null) {
            $$$reportNull$$$0(63);
        }
        return primitiveKotlinType;
    }

    public SimpleType getBooleanType() {
        SimpleType primitiveKotlinType = getPrimitiveKotlinType(PrimitiveType.BOOLEAN);
        if (primitiveKotlinType == null) {
            $$$reportNull$$$0(64);
        }
        return primitiveKotlinType;
    }

    public SimpleType getUnitType() {
        SimpleType defaultType = getUnit().getDefaultType();
        if (defaultType == null) {
            $$$reportNull$$$0(65);
        }
        return defaultType;
    }

    public SimpleType getStringType() {
        SimpleType defaultType = getString().getDefaultType();
        if (defaultType == null) {
            $$$reportNull$$$0(66);
        }
        return defaultType;
    }

    public KotlinType getArrayElementType(KotlinType arrayType) {
        if (arrayType == null) {
            $$$reportNull$$$0(68);
        }
        KotlinType result = getArrayElementTypeOrNull(arrayType);
        if (result == null) {
            throw new IllegalStateException("not array: " + arrayType);
        }
        if (result == null) {
            $$$reportNull$$$0(69);
        }
        return result;
    }

    public KotlinType getArrayElementTypeOrNull(KotlinType arrayType) {
        KotlinType unsignedType;
        if (arrayType == null) {
            $$$reportNull$$$0(70);
        }
        if (isArray(arrayType)) {
            if (arrayType.getArguments().size() != 1) {
                return null;
            }
            return arrayType.getArguments().get(0).getType();
        }
        KotlinType notNullArrayType = TypeUtils.makeNotNullable(arrayType);
        KotlinType primitiveType = this.primitives.invoke().kotlinArrayTypeToPrimitiveKotlinType.get(notNullArrayType);
        if (primitiveType != null) {
            return primitiveType;
        }
        ModuleDescriptor module = DescriptorUtils.getContainingModuleOrNull(notNullArrayType);
        if (module == null || (unsignedType = getElementTypeForUnsignedArray(notNullArrayType, module)) == null) {
            return null;
        }
        return unsignedType;
    }

    private static KotlinType getElementTypeForUnsignedArray(KotlinType notNullArrayType, ModuleDescriptor module) {
        ClassId arrayClassId;
        ClassId elementClassId;
        ClassDescriptor elementClassDescriptor;
        if (notNullArrayType == null) {
            $$$reportNull$$$0(71);
        }
        if (module == null) {
            $$$reportNull$$$0(72);
        }
        ClassifierDescriptor descriptor = notNullArrayType.getConstructor().mo1171getDeclarationDescriptor();
        if (descriptor == null || !UnsignedTypes.INSTANCE.isShortNameOfUnsignedArray(descriptor.getName()) || (arrayClassId = DescriptorUtilsKt.getClassId(descriptor)) == null || (elementClassId = UnsignedTypes.INSTANCE.getUnsignedClassIdByArrayClassId(arrayClassId)) == null || (elementClassDescriptor = FindClassInModuleKt.findClassAcrossModuleDependencies(module, elementClassId)) == null) {
            return null;
        }
        return elementClassDescriptor.getDefaultType();
    }

    public SimpleType getPrimitiveArrayKotlinType(PrimitiveType primitiveType) {
        if (primitiveType == null) {
            $$$reportNull$$$0(73);
        }
        SimpleType simpleType = this.primitives.invoke().primitiveTypeToArrayKotlinType.get(primitiveType);
        if (simpleType == null) {
            $$$reportNull$$$0(74);
        }
        return simpleType;
    }

    public static PrimitiveType getPrimitiveType(DeclarationDescriptor descriptor) {
        if (descriptor == null) {
            $$$reportNull$$$0(76);
        }
        if (StandardNames.FqNames.primitiveTypeShortNames.contains(descriptor.getName())) {
            return StandardNames.FqNames.fqNameToPrimitiveType.get(DescriptorUtils.getFqName(descriptor));
        }
        return null;
    }

    public static PrimitiveType getPrimitiveArrayType(DeclarationDescriptor descriptor) {
        if (descriptor == null) {
            $$$reportNull$$$0(77);
        }
        if (StandardNames.FqNames.primitiveArrayTypeShortNames.contains(descriptor.getName())) {
            return StandardNames.FqNames.arrayClassFqNameToPrimitiveType.get(DescriptorUtils.getFqName(descriptor));
        }
        return null;
    }

    public SimpleType getArrayType(Variance projectionType, KotlinType argument, Annotations annotations) {
        if (projectionType == null) {
            $$$reportNull$$$0(78);
        }
        if (argument == null) {
            $$$reportNull$$$0(79);
        }
        if (annotations == null) {
            $$$reportNull$$$0(80);
        }
        List<TypeProjectionImpl> types = Collections.singletonList(new TypeProjectionImpl(projectionType, argument));
        SimpleType simpleNotNullType = KotlinTypeFactory.simpleNotNullType(TypeAttributesKt.toDefaultAttributes(annotations), getArray(), types);
        if (simpleNotNullType == null) {
            $$$reportNull$$$0(81);
        }
        return simpleNotNullType;
    }

    public SimpleType getArrayType(Variance projectionType, KotlinType argument) {
        if (projectionType == null) {
            $$$reportNull$$$0(82);
        }
        if (argument == null) {
            $$$reportNull$$$0(83);
        }
        SimpleType arrayType = getArrayType(projectionType, argument, Annotations.Companion.getEMPTY());
        if (arrayType == null) {
            $$$reportNull$$$0(84);
        }
        return arrayType;
    }

    public static boolean isArray(KotlinType type) {
        if (type == null) {
            $$$reportNull$$$0(88);
        }
        return isConstructedFromGivenClass(type, StandardNames.FqNames.array);
    }

    public static boolean isArrayOrPrimitiveArray(ClassDescriptor descriptor) {
        if (descriptor == null) {
            $$$reportNull$$$0(89);
        }
        return classFqNameEquals(descriptor, StandardNames.FqNames.array) || getPrimitiveArrayType(descriptor) != null;
    }

    public static boolean isArrayOrPrimitiveArray(KotlinType type) {
        if (type == null) {
            $$$reportNull$$$0(90);
        }
        return isArray(type) || isPrimitiveArray(type);
    }

    public static boolean isPrimitiveArray(KotlinType type) {
        if (type == null) {
            $$$reportNull$$$0(91);
        }
        ClassifierDescriptor descriptor = type.getConstructor().mo1171getDeclarationDescriptor();
        return (descriptor == null || getPrimitiveArrayType(descriptor) == null) ? false : true;
    }

    public static PrimitiveType getPrimitiveArrayElementType(KotlinType type) {
        if (type == null) {
            $$$reportNull$$$0(92);
        }
        ClassifierDescriptor descriptor = type.getConstructor().mo1171getDeclarationDescriptor();
        if (descriptor == null) {
            return null;
        }
        return getPrimitiveArrayType(descriptor);
    }

    public static boolean isPrimitiveType(KotlinType type) {
        if (type == null) {
            $$$reportNull$$$0(94);
        }
        return !type.isMarkedNullable() && isPrimitiveTypeOrNullablePrimitiveType(type);
    }

    public static boolean isPrimitiveTypeOrNullablePrimitiveType(KotlinType type) {
        if (type == null) {
            $$$reportNull$$$0(95);
        }
        ClassifierDescriptor descriptor = type.getConstructor().mo1171getDeclarationDescriptor();
        return (descriptor instanceof ClassDescriptor) && isPrimitiveClass((ClassDescriptor) descriptor);
    }

    public static boolean isPrimitiveClass(ClassDescriptor descriptor) {
        if (descriptor == null) {
            $$$reportNull$$$0(96);
        }
        return getPrimitiveType(descriptor) != null;
    }

    private static boolean isConstructedFromGivenClass(KotlinType type, FqNameUnsafe fqName) {
        if (type == null) {
            $$$reportNull$$$0(97);
        }
        if (fqName == null) {
            $$$reportNull$$$0(98);
        }
        return isTypeConstructorForGivenClass(type.getConstructor(), fqName);
    }

    public static boolean isTypeConstructorForGivenClass(TypeConstructor typeConstructor, FqNameUnsafe fqName) {
        if (typeConstructor == null) {
            $$$reportNull$$$0(101);
        }
        if (fqName == null) {
            $$$reportNull$$$0(102);
        }
        ClassifierDescriptor descriptor = typeConstructor.mo1171getDeclarationDescriptor();
        return (descriptor instanceof ClassDescriptor) && classFqNameEquals(descriptor, fqName);
    }

    private static boolean classFqNameEquals(ClassifierDescriptor descriptor, FqNameUnsafe fqName) {
        if (descriptor == null) {
            $$$reportNull$$$0(103);
        }
        if (fqName == null) {
            $$$reportNull$$$0(104);
        }
        return descriptor.getName().equals(fqName.shortName()) && fqName.equals(DescriptorUtils.getFqName(descriptor));
    }

    private static boolean isNotNullConstructedFromGivenClass(KotlinType type, FqNameUnsafe fqName) {
        if (type == null) {
            $$$reportNull$$$0(105);
        }
        if (fqName == null) {
            $$$reportNull$$$0(106);
        }
        return !type.isMarkedNullable() && isConstructedFromGivenClass(type, fqName);
    }

    public static boolean isSpecialClassWithNoSupertypes(ClassDescriptor descriptor) {
        if (descriptor == null) {
            $$$reportNull$$$0(107);
        }
        return classFqNameEquals(descriptor, StandardNames.FqNames.any) || classFqNameEquals(descriptor, StandardNames.FqNames.nothing);
    }

    public static boolean isAny(ClassDescriptor descriptor) {
        if (descriptor == null) {
            $$$reportNull$$$0(108);
        }
        return classFqNameEquals(descriptor, StandardNames.FqNames.any);
    }

    public static boolean isBoolean(KotlinType type) {
        if (type == null) {
            $$$reportNull$$$0(110);
        }
        return isConstructedFromGivenClassAndNotNullable(type, StandardNames.FqNames._boolean);
    }

    public static boolean isUByteArray(KotlinType type) {
        if (type == null) {
            $$$reportNull$$$0(128);
        }
        return isConstructedFromGivenClassAndNotNullable(type, StandardNames.FqNames.uByteArrayFqName.toUnsafe());
    }

    public static boolean isUShortArray(KotlinType type) {
        if (type == null) {
            $$$reportNull$$$0(129);
        }
        return isConstructedFromGivenClassAndNotNullable(type, StandardNames.FqNames.uShortArrayFqName.toUnsafe());
    }

    public static boolean isUIntArray(KotlinType type) {
        if (type == null) {
            $$$reportNull$$$0(130);
        }
        return isConstructedFromGivenClassAndNotNullable(type, StandardNames.FqNames.uIntArrayFqName.toUnsafe());
    }

    public static boolean isULongArray(KotlinType type) {
        if (type == null) {
            $$$reportNull$$$0(131);
        }
        return isConstructedFromGivenClassAndNotNullable(type, StandardNames.FqNames.uLongArrayFqName.toUnsafe());
    }

    public static boolean isUnsignedArrayType(KotlinType type) {
        if (type == null) {
            $$$reportNull$$$0(132);
        }
        return isUByteArray(type) || isUShortArray(type) || isUIntArray(type) || isULongArray(type);
    }

    private static boolean isConstructedFromGivenClassAndNotNullable(KotlinType type, FqNameUnsafe fqName) {
        if (type == null) {
            $$$reportNull$$$0(134);
        }
        if (fqName == null) {
            $$$reportNull$$$0(135);
        }
        return isConstructedFromGivenClass(type, fqName) && !type.isMarkedNullable();
    }

    public static boolean isNothing(KotlinType type) {
        if (type == null) {
            $$$reportNull$$$0(136);
        }
        return isNothingOrNullableNothing(type) && !TypeUtils.isNullableType(type);
    }

    public static boolean isNothingOrNullableNothing(KotlinType type) {
        if (type == null) {
            $$$reportNull$$$0(138);
        }
        return isConstructedFromGivenClass(type, StandardNames.FqNames.nothing);
    }

    public static boolean isAnyOrNullableAny(KotlinType type) {
        if (type == null) {
            $$$reportNull$$$0(139);
        }
        return isConstructedFromGivenClass(type, StandardNames.FqNames.any);
    }

    public static boolean isNullableAny(KotlinType type) {
        if (type == null) {
            $$$reportNull$$$0(140);
        }
        return isAnyOrNullableAny(type) && type.isMarkedNullable();
    }

    public static boolean isDefaultBound(KotlinType type) {
        if (type == null) {
            $$$reportNull$$$0(141);
        }
        return isNullableAny(type);
    }

    public static boolean isUnit(KotlinType type) {
        if (type == null) {
            $$$reportNull$$$0(142);
        }
        return isNotNullConstructedFromGivenClass(type, StandardNames.FqNames.unit);
    }

    public static boolean isString(KotlinType type) {
        return type != null && isNotNullConstructedFromGivenClass(type, StandardNames.FqNames.string);
    }

    public static boolean isKClass(ClassDescriptor descriptor) {
        if (descriptor == null) {
            $$$reportNull$$$0(158);
        }
        return classFqNameEquals(descriptor, StandardNames.FqNames.kClass);
    }

    public static boolean isDeprecated(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(160);
        }
        if (declarationDescriptor.getOriginal().getAnnotations().hasAnnotation(StandardNames.FqNames.deprecated)) {
            return true;
        }
        if (declarationDescriptor instanceof PropertyDescriptor) {
            boolean isVar = ((PropertyDescriptor) declarationDescriptor).isVar();
            PropertyGetterDescriptor getter = ((PropertyDescriptor) declarationDescriptor).getGetter();
            PropertySetterDescriptor setter = ((PropertyDescriptor) declarationDescriptor).getSetter();
            if (getter != null && isDeprecated(getter)) {
                if (!isVar) {
                    return true;
                }
                if (setter != null && isDeprecated(setter)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}