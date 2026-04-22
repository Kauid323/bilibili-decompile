package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.KTypeBase;
import kotlin.reflect.KType;

/* compiled from: AbstractKType.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0000H&J\u0010\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0005H&J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0000H&J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0000H&R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0010R\u0012\u0010\u0012\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u0015"}, d2 = {"Lkotlin/reflect/jvm/internal/AbstractKType;", "Lkotlin/jvm/internal/KTypeBase;", "<init>", "()V", "isSubtypeOf", "", "other", "makeNullableAsSpecified", "nullable", "makeDefinitelyNotNullAsSpecified", "isDefinitelyNotNull", "abbreviation", "Lkotlin/reflect/KType;", "getAbbreviation", "()Lkotlin/reflect/KType;", "isDefinitelyNotNullType", "()Z", "isNothingType", "isMutableCollectionType", "lowerBoundIfFlexible", "upperBoundIfFlexible", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class AbstractKType implements KTypeBase {
    public abstract KType getAbbreviation();

    public abstract boolean isDefinitelyNotNullType();

    public abstract boolean isMutableCollectionType();

    public abstract boolean isNothingType();

    public abstract boolean isSubtypeOf(AbstractKType abstractKType);

    public abstract AbstractKType lowerBoundIfFlexible();

    public abstract AbstractKType makeDefinitelyNotNullAsSpecified(boolean z);

    public abstract AbstractKType makeNullableAsSpecified(boolean z);

    public abstract AbstractKType upperBoundIfFlexible();
}