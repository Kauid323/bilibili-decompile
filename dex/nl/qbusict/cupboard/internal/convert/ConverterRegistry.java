package nl.qbusict.cupboard.internal.convert;

import android.content.ContentValues;
import android.database.Cursor;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import nl.qbusict.cupboard.Cupboard;
import nl.qbusict.cupboard.convert.EntityConverter;
import nl.qbusict.cupboard.convert.EntityConverterFactory;
import nl.qbusict.cupboard.convert.FieldConverter;
import nl.qbusict.cupboard.convert.FieldConverterFactory;
import nl.qbusict.cupboard.convert.ReflectiveEntityConverter;

public class ConverterRegistry {
    private static final int DEFAULT_ENTITY_CONVERTER_COUNT = 1;
    private static final int DEFAULT_FIELD_CONVERTER_COUNT = 3;
    private Cupboard mCupboard;
    private final ThreadLocal<Map<Type, FutureFieldConverter<?>>> mFieldConverterCalls = new ThreadLocal<>();
    private final ThreadLocal<Map<Class<?>, EntityConverter<?>>> mEntityConverterCalls = new ThreadLocal<>();
    List<FieldConverterFactory> mFieldConverterFactories = new ArrayList(256);
    List<EntityConverterFactory> mEntityConverterFactories = new ArrayList(64);
    private Map<Class<?>, EntityConverter<?>> mEntityConverterCache = new HashMap(128);
    private Map<Type, FieldConverter<?>> mFieldConverterCache = new HashMap(128);

    public ConverterRegistry(Cupboard cupboard) {
        this.mCupboard = cupboard;
        addDefaultEntityConverterFactories();
        addDefaultFieldConverterFactories();
    }

    public ConverterRegistry(ConverterRegistry source, Cupboard cupboard) {
        this.mCupboard = cupboard;
        this.mFieldConverterFactories.addAll(source.mFieldConverterFactories);
        this.mEntityConverterFactories.addAll(source.mEntityConverterFactories);
    }

    private void addDefaultFieldConverterFactories() {
        this.mFieldConverterFactories.add(new DefaultFieldConverterFactory());
        this.mFieldConverterFactories.add(new EnumFieldConverterFactory());
        this.mFieldConverterFactories.add(new EntityFieldConverterFactory());
    }

    private void addDefaultEntityConverterFactories() {
        this.mEntityConverterFactories.add(new EntityConverterFactory() { // from class: nl.qbusict.cupboard.internal.convert.ConverterRegistry.1
            @Override // nl.qbusict.cupboard.convert.EntityConverterFactory
            public <T> EntityConverter<T> create(Cupboard cupboard, Class<T> type) {
                return new ReflectiveEntityConverter(cupboard, type);
            }
        });
    }

    public <T> EntityConverter<T> getEntityConverter(Class<T> type) throws IllegalArgumentException {
        EntityConverter<T> entityConverter = (EntityConverter<T>) this.mEntityConverterCache.get(type);
        if (entityConverter != null) {
            return entityConverter;
        }
        boolean requiresThreadLocalCleanup = false;
        Map<Class<?>, EntityConverter<?>> threadCalls = this.mEntityConverterCalls.get();
        if (threadCalls == null) {
            threadCalls = new HashMap(16);
            this.mEntityConverterCalls.set(threadCalls);
            requiresThreadLocalCleanup = true;
        }
        FutureEntityConverter<T> ongoingCall = (FutureEntityConverter) threadCalls.get(type);
        if (ongoingCall != null) {
            return ongoingCall;
        }
        try {
            FutureEntityConverter<T> call = new FutureEntityConverter<>();
            threadCalls.put(type, call);
            for (EntityConverterFactory factory : this.mEntityConverterFactories) {
                EntityConverter<T> candidate = factory.create(this.mCupboard, type);
                if (candidate != null) {
                    call.setDelegate(candidate);
                    this.mEntityConverterCache.put(type, candidate);
                    return candidate;
                }
            }
            throw new IllegalArgumentException("Cannot convert entity of type " + type);
        } finally {
            threadCalls.remove(type);
            if (requiresThreadLocalCleanup) {
                this.mEntityConverterCalls.remove();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> FieldConverter<T> getFieldConverter(Type type) throws IllegalArgumentException {
        FieldConverter<T> converter = (FieldConverter<T>) this.mFieldConverterCache.get(type);
        if (converter != null) {
            return converter;
        }
        boolean requiresThreadLocalCleanup = false;
        Map<Type, FutureFieldConverter<?>> threadCalls = this.mFieldConverterCalls.get();
        if (threadCalls == null) {
            threadCalls = new HashMap(16);
            this.mFieldConverterCalls.set(threadCalls);
            requiresThreadLocalCleanup = true;
        }
        FutureFieldConverter<?> futureFieldConverter = threadCalls.get(type);
        if (futureFieldConverter != null) {
            Map<Class<?>, EntityConverter<?>> entityThreadCalls = this.mEntityConverterCalls.get();
            if (!(type instanceof Class) || !this.mCupboard.isRegisteredEntity((Class) type) || !entityThreadCalls.containsKey(type)) {
                return futureFieldConverter;
            }
        }
        try {
            FutureFieldConverter<?> futureFieldConverter2 = new FutureFieldConverter<>();
            threadCalls.put(type, futureFieldConverter2);
            for (FieldConverterFactory factory : this.mFieldConverterFactories) {
                FieldConverter fieldConverter = (FieldConverter<T>) factory.create(this.mCupboard, type);
                if (fieldConverter != null) {
                    futureFieldConverter2.setDelegate(fieldConverter);
                    this.mFieldConverterCache.put(type, fieldConverter);
                    return fieldConverter;
                }
            }
            throw new IllegalArgumentException("Cannot convert field of type" + type);
        } finally {
            threadCalls.remove(type);
            if (requiresThreadLocalCleanup) {
                this.mFieldConverterCalls.remove();
            }
        }
    }

    public <T> EntityConverter<T> getDelegateEntityConverter(EntityConverterFactory skipPast, Class<T> entityClass) throws IllegalArgumentException {
        boolean factoryFound = false;
        for (EntityConverterFactory factory : this.mEntityConverterFactories) {
            if (!factoryFound) {
                if (factory == skipPast) {
                    factoryFound = true;
                }
            } else {
                EntityConverter<T> candidate = factory.create(this.mCupboard, entityClass);
                if (candidate != null) {
                    return candidate;
                }
            }
        }
        throw new IllegalArgumentException("Cannot convert entity of type " + entityClass);
    }

    public FieldConverter getDelegateFieldConverter(FieldConverterFactory skipPast, Type fieldType) throws IllegalArgumentException {
        boolean factoryFound = false;
        for (FieldConverterFactory factory : this.mFieldConverterFactories) {
            if (!factoryFound) {
                if (factory == skipPast) {
                    factoryFound = true;
                }
            } else {
                FieldConverter candidate = factory.create(this.mCupboard, fieldType);
                if (candidate != null) {
                    return candidate;
                }
            }
        }
        throw new IllegalArgumentException("Cannot convert field of type " + fieldType);
    }

    public void registerEntityConverterFactory(EntityConverterFactory factory) {
        this.mEntityConverterFactories.add(this.mEntityConverterFactories.size() - 1, factory);
    }

    public void registerFieldConverterFactory(FieldConverterFactory factory) {
        this.mFieldConverterFactories.add(this.mFieldConverterFactories.size() - 3, factory);
    }

    public <T> void registerFieldConverter(Class<T> clz, FieldConverter<T> converter) {
        this.mFieldConverterCache.put(clz, converter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static class FutureFieldConverter<T> implements FieldConverter<T> {
        private FieldConverter<T> mDelegate;

        private FutureFieldConverter() {
        }

        @Override // nl.qbusict.cupboard.convert.FieldConverter
        public T fromCursorValue(Cursor cursor, int columnIndex) {
            if (this.mDelegate == null) {
                throw new IllegalStateException();
            }
            return this.mDelegate.fromCursorValue(cursor, columnIndex);
        }

        @Override // nl.qbusict.cupboard.convert.FieldConverter
        public void toContentValue(T value, String key, ContentValues values) {
            if (this.mDelegate == null) {
                throw new IllegalStateException();
            }
            this.mDelegate.toContentValue(value, key, values);
        }

        @Override // nl.qbusict.cupboard.convert.FieldConverter
        public EntityConverter.ColumnType getColumnType() {
            if (this.mDelegate == null) {
                throw new IllegalStateException();
            }
            return this.mDelegate.getColumnType();
        }

        void setDelegate(FieldConverter<T> delegate) {
            if (this.mDelegate != null) {
                throw new AssertionError();
            }
            this.mDelegate = delegate;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static class FutureEntityConverter<T> implements EntityConverter<T> {
        private EntityConverter<T> mDelegate;

        private FutureEntityConverter() {
        }

        @Override // nl.qbusict.cupboard.convert.EntityConverter
        public T fromCursor(Cursor cursor) {
            if (this.mDelegate == null) {
                throw new IllegalStateException();
            }
            return this.mDelegate.fromCursor(cursor);
        }

        @Override // nl.qbusict.cupboard.convert.EntityConverter
        public void toValues(T object, ContentValues values) {
            if (this.mDelegate == null) {
                throw new IllegalStateException();
            }
            this.mDelegate.toValues(object, values);
        }

        @Override // nl.qbusict.cupboard.convert.EntityConverter
        public List<EntityConverter.Column> getColumns() {
            if (this.mDelegate == null) {
                throw new IllegalStateException();
            }
            return this.mDelegate.getColumns();
        }

        @Override // nl.qbusict.cupboard.convert.EntityConverter
        public void setId(Long id, T instance) {
            if (this.mDelegate == null) {
                throw new IllegalStateException();
            }
            this.mDelegate.setId(id, instance);
        }

        @Override // nl.qbusict.cupboard.convert.EntityConverter
        public Long getId(T instance) {
            if (this.mDelegate == null) {
                throw new IllegalStateException();
            }
            return this.mDelegate.getId(instance);
        }

        @Override // nl.qbusict.cupboard.convert.EntityConverter
        public String getTable() {
            if (this.mDelegate == null) {
                throw new IllegalStateException();
            }
            return this.mDelegate.getTable();
        }

        void setDelegate(EntityConverter<T> delegate) {
            if (this.mDelegate != null) {
                throw new AssertionError();
            }
            this.mDelegate = delegate;
        }
    }
}