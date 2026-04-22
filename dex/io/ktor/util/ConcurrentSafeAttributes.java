package io.ktor.util;

import j$.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AttributesJvm.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\n\u001a\u00028\u0000\"\b\b\u0000\u0010\u0005*\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016¢\u0006\u0004\b\n\u0010\u000bR,\u0010\r\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00040\f8\u0014X\u0094\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lio/ktor/util/ConcurrentSafeAttributes;", "Lio/ktor/util/AttributesJvmBase;", "<init>", "()V", "", "T", "Lio/ktor/util/AttributeKey;", "key", "Lkotlin/Function0;", "block", "computeIfAbsent", "(Lio/ktor/util/AttributeKey;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "j$/util/concurrent/ConcurrentHashMap", "map", "Lj$/util/concurrent/ConcurrentHashMap;", "getMap", "()Lj$/util/concurrent/ConcurrentHashMap;", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class ConcurrentSafeAttributes extends AttributesJvmBase {
    private final ConcurrentHashMap<AttributeKey<?>, Object> map = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.ktor.util.AttributesJvmBase
    /* renamed from: getMap */
    public ConcurrentHashMap<AttributeKey<?>, Object> mo1445getMap() {
        return this.map;
    }

    @Override // io.ktor.util.Attributes
    public <T> T computeIfAbsent(AttributeKey<T> attributeKey, Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(attributeKey, "key");
        Intrinsics.checkNotNullParameter(function0, "block");
        T t = (T) mo1445getMap().get(attributeKey);
        if (t != null) {
            return t;
        }
        Object result = function0.invoke();
        T t2 = (T) mo1445getMap().putIfAbsent(attributeKey, result);
        if (t2 == null) {
            t2 = (T) result;
        }
        Intrinsics.checkNotNull(t2, "null cannot be cast to non-null type T of io.ktor.util.ConcurrentSafeAttributes.computeIfAbsent");
        return t2;
    }
}