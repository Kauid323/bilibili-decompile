package nl.qbusict.cupboard;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import nl.qbusict.cupboard.convert.EntityConverter;

public class QueryResultIterable<T> implements Iterable<T> {
    private final Cursor mCursor;
    private final int mPosition;
    private final EntityConverter<T> mTranslator;

    /* JADX INFO: Access modifiers changed from: package-private */
    public QueryResultIterable(Cursor cursor, EntityConverter<T> translator) {
        if (cursor.getPosition() > -1) {
            this.mPosition = cursor.getPosition();
        } else {
            this.mPosition = -1;
        }
        this.mCursor = cursor;
        this.mTranslator = translator;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        this.mCursor.moveToPosition(this.mPosition);
        return new QueryResultIterator(this.mCursor, this.mTranslator);
    }

    public void close() {
        if (!this.mCursor.isClosed()) {
            this.mCursor.close();
        }
    }

    public Cursor getCursor() {
        return this.mCursor;
    }

    public T get() {
        return get(true);
    }

    public T get(boolean close) {
        try {
            Iterator<T> itr = iterator();
            if (itr.hasNext()) {
                return itr.next();
            }
            if (close) {
                close();
                return null;
            }
            return null;
        } finally {
            if (close) {
                close();
            }
        }
    }

    public List<T> list() {
        return list(true);
    }

    public List<T> list(boolean close) {
        List<T> result = new ArrayList<>(this.mCursor.getCount());
        try {
            Iterator<T> it = iterator();
            while (it.hasNext()) {
                T obj = it.next();
                result.add(obj);
            }
            return result;
        } finally {
            if (close) {
                close();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static class QueryResultIterator<E> implements Iterator<E> {
        private final int mCount;
        private final Cursor mCursor;
        private int mPosition;
        private final EntityConverter<E> mTranslator;

        public QueryResultIterator(Cursor cursor, EntityConverter<E> translator) {
            this.mCursor = new PreferredColumnOrderCursorWrapper(cursor, translator.getColumns());
            this.mTranslator = translator;
            this.mPosition = cursor.getPosition();
            this.mCount = cursor.getCount();
            if (this.mPosition != -1) {
                this.mPosition--;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.mPosition < this.mCount - 1;
        }

        @Override // java.util.Iterator
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Cursor cursor = this.mCursor;
            int i = this.mPosition + 1;
            this.mPosition = i;
            cursor.moveToPosition(i);
            return this.mTranslator.fromCursor(this.mCursor);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}