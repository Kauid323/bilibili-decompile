package j$.util.concurrent;

import java.util.concurrent.Flow;

public final class Flow {
    static final int DEFAULT_BUFFER_SIZE = 256;

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public interface Processor<T, R> extends Subscriber<T>, Publisher<R> {
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public interface Publisher<T> {

        /* compiled from: D8$$SyntheticClass */
        /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
        public final /* synthetic */ class VivifiedWrapper implements Publisher {
            public final /* synthetic */ Flow.Publisher wrappedValue;

            private /* synthetic */ VivifiedWrapper(Flow.Publisher publisher) {
                this.wrappedValue = publisher;
            }

            public static /* synthetic */ Publisher convert(Flow.Publisher publisher) {
                if (publisher == null) {
                    return null;
                }
                return publisher instanceof Wrapper ? Publisher.this : new VivifiedWrapper(publisher);
            }

            public /* synthetic */ boolean equals(Object obj) {
                Flow.Publisher publisher = this.wrappedValue;
                if (obj instanceof VivifiedWrapper) {
                    obj = ((VivifiedWrapper) obj).wrappedValue;
                }
                return publisher.equals(obj);
            }

            public /* synthetic */ int hashCode() {
                return this.wrappedValue.hashCode();
            }

            @Override // j$.util.concurrent.Flow.Publisher
            public /* synthetic */ void subscribe(Subscriber subscriber) {
                this.wrappedValue.subscribe(Subscriber.Wrapper.convert(subscriber));
            }
        }

        /* compiled from: D8$$SyntheticClass */
        /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
        public final /* synthetic */ class Wrapper implements Flow.Publisher {
            private /* synthetic */ Wrapper() {
            }

            public static /* synthetic */ Flow.Publisher convert(Publisher publisher) {
                if (publisher == null) {
                    return null;
                }
                return publisher instanceof VivifiedWrapper ? ((VivifiedWrapper) publisher).wrappedValue : new Wrapper();
            }

            public /* synthetic */ boolean equals(Object obj) {
                Publisher publisher = Publisher.this;
                if (obj instanceof Wrapper) {
                    obj = Publisher.this;
                }
                return publisher.equals(obj);
            }

            public /* synthetic */ int hashCode() {
                return Publisher.this.hashCode();
            }

            @Override // java.util.concurrent.Flow.Publisher
            public /* synthetic */ void subscribe(Flow.Subscriber subscriber) {
                Publisher.this.subscribe(Subscriber.VivifiedWrapper.convert(subscriber));
            }
        }

        void subscribe(Subscriber<? super T> subscriber);
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public interface Subscriber<T> {

        /* compiled from: D8$$SyntheticClass */
        /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
        public final /* synthetic */ class VivifiedWrapper implements Subscriber {
            public final /* synthetic */ Flow.Subscriber wrappedValue;

            private /* synthetic */ VivifiedWrapper(Flow.Subscriber subscriber) {
                this.wrappedValue = subscriber;
            }

            public static /* synthetic */ Subscriber convert(Flow.Subscriber subscriber) {
                if (subscriber == null) {
                    return null;
                }
                return subscriber instanceof Wrapper ? Subscriber.this : new VivifiedWrapper(subscriber);
            }

            public /* synthetic */ boolean equals(Object obj) {
                Flow.Subscriber subscriber = this.wrappedValue;
                if (obj instanceof VivifiedWrapper) {
                    obj = ((VivifiedWrapper) obj).wrappedValue;
                }
                return subscriber.equals(obj);
            }

            public /* synthetic */ int hashCode() {
                return this.wrappedValue.hashCode();
            }

            @Override // j$.util.concurrent.Flow.Subscriber
            public /* synthetic */ void onComplete() {
                this.wrappedValue.onComplete();
            }

            @Override // j$.util.concurrent.Flow.Subscriber
            public /* synthetic */ void onError(Throwable th) {
                this.wrappedValue.onError(th);
            }

            @Override // j$.util.concurrent.Flow.Subscriber
            public /* synthetic */ void onNext(Object obj) {
                this.wrappedValue.onNext(obj);
            }

            @Override // j$.util.concurrent.Flow.Subscriber
            public /* synthetic */ void onSubscribe(Subscription subscription) {
                this.wrappedValue.onSubscribe(Subscription.Wrapper.convert(subscription));
            }
        }

        /* compiled from: D8$$SyntheticClass */
        /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
        public final /* synthetic */ class Wrapper implements Flow.Subscriber {
            private /* synthetic */ Wrapper() {
            }

            public static /* synthetic */ Flow.Subscriber convert(Subscriber subscriber) {
                if (subscriber == null) {
                    return null;
                }
                return subscriber instanceof VivifiedWrapper ? ((VivifiedWrapper) subscriber).wrappedValue : new Wrapper();
            }

            public /* synthetic */ boolean equals(Object obj) {
                Subscriber subscriber = Subscriber.this;
                if (obj instanceof Wrapper) {
                    obj = Subscriber.this;
                }
                return subscriber.equals(obj);
            }

            public /* synthetic */ int hashCode() {
                return Subscriber.this.hashCode();
            }

            @Override // java.util.concurrent.Flow.Subscriber
            public /* synthetic */ void onComplete() {
                Subscriber.this.onComplete();
            }

            @Override // java.util.concurrent.Flow.Subscriber
            public /* synthetic */ void onError(Throwable th) {
                Subscriber.this.onError(th);
            }

            @Override // java.util.concurrent.Flow.Subscriber
            public /* synthetic */ void onNext(Object obj) {
                Subscriber.this.onNext(obj);
            }

            @Override // java.util.concurrent.Flow.Subscriber
            public /* synthetic */ void onSubscribe(Flow.Subscription subscription) {
                Subscriber.this.onSubscribe(Subscription.VivifiedWrapper.convert(subscription));
            }
        }

        void onComplete();

        void onError(Throwable th);

        void onNext(T t);

        void onSubscribe(Subscription subscription);
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public interface Subscription {

        /* compiled from: D8$$SyntheticClass */
        /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
        public final /* synthetic */ class VivifiedWrapper implements Subscription {
            public final /* synthetic */ Flow.Subscription wrappedValue;

            private /* synthetic */ VivifiedWrapper(Flow.Subscription subscription) {
                this.wrappedValue = subscription;
            }

            public static /* synthetic */ Subscription convert(Flow.Subscription subscription) {
                if (subscription == null) {
                    return null;
                }
                return subscription instanceof Wrapper ? Subscription.this : new VivifiedWrapper(subscription);
            }

            @Override // j$.util.concurrent.Flow.Subscription
            public /* synthetic */ void cancel() {
                this.wrappedValue.cancel();
            }

            public /* synthetic */ boolean equals(Object obj) {
                Flow.Subscription subscription = this.wrappedValue;
                if (obj instanceof VivifiedWrapper) {
                    obj = ((VivifiedWrapper) obj).wrappedValue;
                }
                return subscription.equals(obj);
            }

            public /* synthetic */ int hashCode() {
                return this.wrappedValue.hashCode();
            }

            @Override // j$.util.concurrent.Flow.Subscription
            public /* synthetic */ void request(long j) {
                this.wrappedValue.request(j);
            }
        }

        /* compiled from: D8$$SyntheticClass */
        /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
        public final /* synthetic */ class Wrapper implements Flow.Subscription {
            private /* synthetic */ Wrapper() {
            }

            public static /* synthetic */ Flow.Subscription convert(Subscription subscription) {
                if (subscription == null) {
                    return null;
                }
                return subscription instanceof VivifiedWrapper ? ((VivifiedWrapper) subscription).wrappedValue : new Wrapper();
            }

            @Override // java.util.concurrent.Flow.Subscription
            public /* synthetic */ void cancel() {
                Subscription.this.cancel();
            }

            public /* synthetic */ boolean equals(Object obj) {
                Subscription subscription = Subscription.this;
                if (obj instanceof Wrapper) {
                    obj = Subscription.this;
                }
                return subscription.equals(obj);
            }

            public /* synthetic */ int hashCode() {
                return Subscription.this.hashCode();
            }

            @Override // java.util.concurrent.Flow.Subscription
            public /* synthetic */ void request(long j) {
                Subscription.this.request(j);
            }
        }

        void cancel();

        void request(long j);
    }

    private Flow() {
    }

    public static int defaultBufferSize() {
        return 256;
    }
}