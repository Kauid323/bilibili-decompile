package io.ktor.util;

import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CryptoJvm.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0083@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0096\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000e\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0011\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0017\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u001b\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001f\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\"\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006#"}, d2 = {"Lio/ktor/util/DigestImpl;", "Lio/ktor/util/Digest;", "Ljava/security/MessageDigest;", "delegate", "constructor-impl", "(Ljava/security/MessageDigest;)Ljava/security/MessageDigest;", "", "bytes", "", "plusAssign-impl", "(Ljava/security/MessageDigest;[B)V", "plusAssign", "reset-impl", "(Ljava/security/MessageDigest;)V", "reset", "build-impl", "(Ljava/security/MessageDigest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "build", "", "other", "", "equals-impl", "(Ljava/security/MessageDigest;Ljava/lang/Object;)Z", "equals", "", "hashCode-impl", "(Ljava/security/MessageDigest;)I", "hashCode", "", "toString-impl", "(Ljava/security/MessageDigest;)Ljava/lang/String;", "toString", "Ljava/security/MessageDigest;", "getDelegate", "()Ljava/security/MessageDigest;", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class DigestImpl implements Digest {
    private final MessageDigest delegate;

    /* renamed from: box-impl */
    public static final /* synthetic */ DigestImpl m1448boximpl(MessageDigest messageDigest) {
        return new DigestImpl(messageDigest);
    }

    /* renamed from: constructor-impl */
    public static MessageDigest m1450constructorimpl(MessageDigest messageDigest) {
        Intrinsics.checkNotNullParameter(messageDigest, "delegate");
        return messageDigest;
    }

    /* renamed from: equals-impl */
    public static boolean m1451equalsimpl(MessageDigest messageDigest, Object obj) {
        return (obj instanceof DigestImpl) && Intrinsics.areEqual(messageDigest, ((DigestImpl) obj).m1457unboximpl());
    }

    /* renamed from: equals-impl0 */
    public static final boolean m1452equalsimpl0(MessageDigest messageDigest, MessageDigest messageDigest2) {
        return Intrinsics.areEqual(messageDigest, messageDigest2);
    }

    /* renamed from: hashCode-impl */
    public static int m1453hashCodeimpl(MessageDigest messageDigest) {
        return messageDigest.hashCode();
    }

    /* renamed from: toString-impl */
    public static String m1456toStringimpl(MessageDigest messageDigest) {
        return "DigestImpl(delegate=" + messageDigest + ')';
    }

    public boolean equals(Object obj) {
        return m1451equalsimpl(this.delegate, obj);
    }

    public int hashCode() {
        return m1453hashCodeimpl(this.delegate);
    }

    public String toString() {
        return m1456toStringimpl(this.delegate);
    }

    /* renamed from: unbox-impl */
    public final /* synthetic */ MessageDigest m1457unboximpl() {
        return this.delegate;
    }

    private /* synthetic */ DigestImpl(MessageDigest delegate) {
        this.delegate = delegate;
    }

    public final MessageDigest getDelegate() {
        return this.delegate;
    }

    @Override // io.ktor.util.Digest
    public void plusAssign(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        m1454plusAssignimpl(this.delegate, bytes);
    }

    /* renamed from: plusAssign-impl */
    public static void m1454plusAssignimpl(MessageDigest arg0, byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        arg0.update(bytes);
    }

    @Override // io.ktor.util.Digest
    public void reset() {
        m1455resetimpl(this.delegate);
    }

    /* renamed from: reset-impl */
    public static void m1455resetimpl(MessageDigest arg0) {
        arg0.reset();
    }

    /* renamed from: build-impl */
    public static Object m1449buildimpl(MessageDigest arg0, Continuation<? super byte[]> continuation) {
        byte[] digest = arg0.digest();
        Intrinsics.checkNotNullExpressionValue(digest, "digest(...)");
        return digest;
    }

    @Override // io.ktor.util.Digest
    public Object build(Continuation<? super byte[]> continuation) {
        return m1449buildimpl(this.delegate, continuation);
    }
}