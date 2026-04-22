package j$.util.stream;

import j$.util.Spliterator;
import j$.util.stream.BaseStream;
import j$.util.stream.DoubleStream;
import j$.util.stream.IntStream;
import j$.util.stream.LongStream;
import j$.util.stream.Stream;
import java.util.Iterator;

public interface BaseStream<T, S extends BaseStream<T, S>> extends AutoCloseable {

    /* compiled from: D8$$SyntheticClass */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public final /* synthetic */ class VivifiedWrapper implements BaseStream {
        public final /* synthetic */ java.util.stream.BaseStream wrappedValue;

        private /* synthetic */ VivifiedWrapper(java.util.stream.BaseStream baseStream) {
            this.wrappedValue = baseStream;
        }

        public static /* synthetic */ BaseStream convert(java.util.stream.BaseStream baseStream) {
            if (baseStream == null) {
                return null;
            }
            return baseStream instanceof Wrapper ? BaseStream.this : baseStream instanceof java.util.stream.DoubleStream ? DoubleStream.VivifiedWrapper.convert((java.util.stream.DoubleStream) baseStream) : baseStream instanceof java.util.stream.IntStream ? IntStream.VivifiedWrapper.convert((java.util.stream.IntStream) baseStream) : baseStream instanceof java.util.stream.LongStream ? LongStream.VivifiedWrapper.convert((java.util.stream.LongStream) baseStream) : baseStream instanceof java.util.stream.Stream ? Stream.VivifiedWrapper.convert((java.util.stream.Stream) baseStream) : new VivifiedWrapper(baseStream);
        }

        @Override // j$.util.stream.BaseStream, java.lang.AutoCloseable
        public /* synthetic */ void close() {
            this.wrappedValue.close();
        }

        public /* synthetic */ boolean equals(Object obj) {
            java.util.stream.BaseStream baseStream = this.wrappedValue;
            if (obj instanceof VivifiedWrapper) {
                obj = ((VivifiedWrapper) obj).wrappedValue;
            }
            return baseStream.equals(obj);
        }

        public /* synthetic */ int hashCode() {
            return this.wrappedValue.hashCode();
        }

        @Override // j$.util.stream.BaseStream
        public /* synthetic */ boolean isParallel() {
            return this.wrappedValue.isParallel();
        }

        @Override // j$.util.stream.BaseStream
        public /* synthetic */ Iterator iterator() {
            return this.wrappedValue.iterator();
        }

        @Override // j$.util.stream.BaseStream
        public /* synthetic */ BaseStream onClose(Runnable runnable) {
            return convert(this.wrappedValue.onClose(runnable));
        }

        @Override // j$.util.stream.BaseStream
        public /* synthetic */ BaseStream parallel() {
            return convert(this.wrappedValue.parallel());
        }

        @Override // j$.util.stream.BaseStream
        public /* synthetic */ BaseStream sequential() {
            return convert(this.wrappedValue.sequential());
        }

        @Override // j$.util.stream.BaseStream
        public /* synthetic */ Spliterator spliterator() {
            return Spliterator.VivifiedWrapper.convert(this.wrappedValue.spliterator());
        }

        @Override // j$.util.stream.BaseStream
        public /* synthetic */ BaseStream unordered() {
            return convert(this.wrappedValue.unordered());
        }
    }

    /* compiled from: D8$$SyntheticClass */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public final /* synthetic */ class Wrapper implements java.util.stream.BaseStream {
        private /* synthetic */ Wrapper() {
            BaseStream.this = r1;
        }

        public static /* synthetic */ java.util.stream.BaseStream convert(BaseStream baseStream) {
            if (baseStream == null) {
                return null;
            }
            return baseStream instanceof VivifiedWrapper ? ((VivifiedWrapper) baseStream).wrappedValue : baseStream instanceof DoubleStream ? DoubleStream.Wrapper.convert((DoubleStream) baseStream) : baseStream instanceof IntStream ? IntStream.Wrapper.convert((IntStream) baseStream) : baseStream instanceof LongStream ? LongStream.Wrapper.convert((LongStream) baseStream) : baseStream instanceof Stream ? Stream.Wrapper.convert((Stream) baseStream) : new Wrapper();
        }

        @Override // java.util.stream.BaseStream, java.lang.AutoCloseable
        public /* synthetic */ void close() {
            BaseStream.this.close();
        }

        public /* synthetic */ boolean equals(Object obj) {
            BaseStream baseStream = BaseStream.this;
            if (obj instanceof Wrapper) {
                obj = BaseStream.this;
            }
            return baseStream.equals(obj);
        }

        public /* synthetic */ int hashCode() {
            return BaseStream.this.hashCode();
        }

        @Override // java.util.stream.BaseStream
        public /* synthetic */ boolean isParallel() {
            return BaseStream.this.isParallel();
        }

        @Override // java.util.stream.BaseStream
        public /* synthetic */ Iterator iterator() {
            return BaseStream.this.iterator();
        }

        @Override // java.util.stream.BaseStream
        public /* synthetic */ java.util.stream.BaseStream onClose(Runnable runnable) {
            return convert(BaseStream.this.onClose(runnable));
        }

        @Override // java.util.stream.BaseStream
        public /* synthetic */ java.util.stream.BaseStream parallel() {
            return convert(BaseStream.this.parallel());
        }

        @Override // java.util.stream.BaseStream
        public /* synthetic */ java.util.stream.BaseStream sequential() {
            return convert(BaseStream.this.sequential());
        }

        @Override // java.util.stream.BaseStream
        public /* synthetic */ java.util.Spliterator spliterator() {
            return Spliterator.Wrapper.convert(BaseStream.this.spliterator());
        }

        @Override // java.util.stream.BaseStream
        public /* synthetic */ java.util.stream.BaseStream unordered() {
            return convert(BaseStream.this.unordered());
        }
    }

    @Override // java.lang.AutoCloseable
    void close();

    boolean isParallel();

    Iterator<T> iterator();

    S onClose(Runnable runnable);

    S parallel();

    S sequential();

    Spliterator<T> spliterator();

    S unordered();
}