package nl.qbusict.cupboard;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import java.util.Collection;
import java.util.List;
import nl.qbusict.cupboard.convert.EntityConverter;

public class ProviderCompartment extends BaseCompartment {
    private static final String QUERY_BY_ID = "_id = ?";
    private final ContentResolver mResolver;

    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static class QueryBuilder<T> {
        private final ProviderCompartment mCompartment;
        private final Class<T> mEntityClass;
        private String mOrder;
        private String[] mProjection;
        private String mSelection;
        private String[] mSelectionArgs;
        private final Uri mUri;

        public QueryBuilder(Uri uri, Class<T> entityClass, ProviderCompartment compartment) {
            this.mEntityClass = entityClass;
            this.mCompartment = compartment;
            this.mUri = uri;
        }

        public QueryBuilder<T> withSelection(String selection, String... args) {
            this.mSelection = selection;
            this.mSelectionArgs = args;
            return this;
        }

        public QueryBuilder<T> orderBy(String order) {
            this.mOrder = order;
            return this;
        }

        public QueryBuilder<T> withProjection(String... projection) {
            this.mProjection = projection;
            return this;
        }

        public QueryResultIterable<T> query() {
            return this.mCompartment.query(this.mUri, this.mEntityClass, this.mProjection, this.mSelection, this.mSelectionArgs, this.mOrder);
        }

        public Cursor getCursor() {
            return query().getCursor();
        }

        public T get() {
            return query().get();
        }

        public List<T> list() {
            return query().list();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ProviderCompartment(Cupboard cupboard, Context context) {
        super(cupboard);
        this.mResolver = context.getContentResolver();
    }

    public <T> T get(Uri uri, Class<T> entityClass) {
        return query(uri, entityClass).query().get();
    }

    public <T> Uri put(Uri uri, T entity) {
        EntityConverter<T> converter = getConverter(entity.getClass());
        ContentValues values = new ContentValues(converter.getColumns().size());
        converter.toValues(entity, values);
        Long id = converter.getId(entity);
        if (id == null) {
            return this.mResolver.insert(uri, values);
        }
        return this.mResolver.insert(ContentUris.withAppendedId(uri, id.longValue()), values);
    }

    public <T> int put(Uri uri, Class<T> entityClass, T... entities) {
        EntityConverter<T> converter = getConverter(entityClass);
        ContentValues[] values = new ContentValues[entities.length];
        int size = converter.getColumns().size();
        for (int i = 0; i < entities.length; i++) {
            values[i] = new ContentValues(size);
            converter.toValues(entities[i], values[i]);
        }
        return this.mResolver.bulkInsert(uri, values);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> int put(Uri uri, Class<T> entityClass, Collection<T> entities) {
        return put(uri, entityClass, entities.toArray());
    }

    public <T> int delete(Uri uri, T entity) {
        EntityConverter<T> converter = getConverter(entity.getClass());
        Long id = converter.getId(entity);
        if (id == null) {
            return 0;
        }
        return this.mResolver.delete(ContentUris.withAppendedId(uri, id.longValue()), null, null);
    }

    public int delete(Uri uri, String selection, String... selectionArgs) {
        return this.mResolver.delete(uri, selection, selectionArgs);
    }

    public int update(Uri uri, ContentValues values) {
        if (values.containsKey("_id")) {
            return this.mResolver.update(ContentUris.withAppendedId(uri, values.getAsLong("_id").longValue()), values, QUERY_BY_ID, new String[]{values.getAsString("_id")});
        }
        return this.mResolver.update(uri, values, null, null);
    }

    public int update(Uri uri, ContentValues values, String selection, String... selectionArgs) {
        return this.mResolver.update(uri, values, selection, selectionArgs);
    }

    public <T> QueryBuilder<T> query(Uri uri, Class<T> entityClass) {
        return new QueryBuilder<>(uri, entityClass, this);
    }

    public <T> T get(Uri uri, T entity) {
        EntityConverter<T> converter = getConverter(entity.getClass());
        Long id = converter.getId(entity);
        if (id == null) {
            throw new IllegalArgumentException("entity does not have it's id set");
        }
        return (T) get(ContentUris.withAppendedId(uri, id.longValue()), (Class<Object>) entity.getClass());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> QueryResultIterable<T> query(Uri uri, Class<T> entityClass, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        EntityConverter<T> converter = getConverter(entityClass);
        Cursor cursor = this.mResolver.query(uri, projection, selection, selectionArgs, sortOrder);
        if (cursor == null) {
            cursor = new MatrixCursor(new String[]{"_id"});
        }
        return new QueryResultIterable<>(cursor, converter);
    }
}