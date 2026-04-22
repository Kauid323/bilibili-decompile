package nl.qbusict.cupboard;

import android.content.ContentProviderOperation;
import android.content.ContentUris;
import android.content.ContentValues;
import android.net.Uri;
import java.util.ArrayList;
import nl.qbusict.cupboard.convert.EntityConverter;

public class ProviderOperationsCompartment extends BaseCompartment {
    private final ArrayList<ContentProviderOperation> mOperations;
    private int mYieldAfter;
    private boolean mYieldAllowed;

    /* JADX INFO: Access modifiers changed from: protected */
    public ProviderOperationsCompartment(Cupboard cupboard, ArrayList<ContentProviderOperation> operations) {
        super(cupboard);
        this.mYieldAllowed = false;
        this.mYieldAfter = -1;
        this.mOperations = operations;
    }

    public <T> ProviderOperationsCompartment put(Uri uri, T entity) {
        EntityConverter<T> converter = getConverter(entity.getClass());
        ContentValues values = new ContentValues(converter.getColumns().size());
        converter.toValues(entity, values);
        Long id = converter.getId(entity);
        if (id == null) {
            this.mOperations.add(ContentProviderOperation.newInsert(uri).withValues(values).withYieldAllowed(shouldYield()).build());
        } else {
            this.mOperations.add(ContentProviderOperation.newInsert(ContentUris.withAppendedId(uri, id.longValue())).withYieldAllowed(shouldYield()).withValues(values).build());
        }
        this.mYieldAllowed = false;
        return this;
    }

    public ProviderOperationsCompartment yield() {
        this.mYieldAllowed = true;
        return this;
    }

    public ProviderOperationsCompartment yieldAfter(int operationCount) {
        this.mYieldAfter = operationCount;
        return this;
    }

    public <T> ProviderOperationsCompartment put(Uri uri, Class<T> entityClass, T... entities) {
        boolean mWasYieldAllowed = this.mYieldAllowed;
        this.mYieldAllowed = false;
        EntityConverter<T> converter = getConverter(entityClass);
        ContentValues[] values = new ContentValues[entities.length];
        int size = converter.getColumns().size();
        for (int i = 0; i < entities.length; i++) {
            values[i] = new ContentValues(size);
            converter.toValues(entities[i], values[i]);
        }
        for (int i2 = 0; i2 < entities.length; i2++) {
            if (i2 == entities.length - 1) {
                this.mYieldAllowed = mWasYieldAllowed;
            }
            put(uri, entities[i2]);
        }
        return this;
    }

    public <T> ProviderOperationsCompartment delete(Uri uri, T entity) {
        EntityConverter<T> converter = getConverter(entity.getClass());
        Long id = converter.getId(entity);
        if (id == null) {
            return this;
        }
        this.mOperations.add(ContentProviderOperation.newDelete(ContentUris.withAppendedId(uri, id.longValue())).withYieldAllowed(this.mYieldAllowed).build());
        return this;
    }

    public ArrayList<ContentProviderOperation> getOperations() {
        return this.mOperations;
    }

    private boolean shouldYield() {
        if (this.mYieldAllowed) {
            return true;
        }
        return this.mYieldAfter > 0 && this.mOperations.size() + 1 >= this.mYieldAfter && (this.mOperations.size() + 1) % this.mYieldAfter == 0;
    }
}