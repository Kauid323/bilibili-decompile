package io.ktor.util.converters;

import io.ktor.util.reflect.TypeInfo;
import java.util.List;
import kotlin.Metadata;

/* compiled from: ConversionService.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J'\u0010\u0007\u001a\u0004\u0018\u00010\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0001H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lio/ktor/util/converters/ConversionService;", "", "", "", "values", "Lio/ktor/util/reflect/TypeInfo;", "type", "fromValues", "(Ljava/util/List;Lio/ktor/util/reflect/TypeInfo;)Ljava/lang/Object;", "value", "toValues", "(Ljava/lang/Object;)Ljava/util/List;", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ConversionService {
    Object fromValues(List<String> list, TypeInfo typeInfo);

    List<String> toValues(Object obj);
}