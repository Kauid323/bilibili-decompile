package nl.qbusict.cupboard.convert;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import nl.qbusict.cupboard.annotation.CompositeIndex;
import nl.qbusict.cupboard.annotation.Index;

public class IndexBuilder {
    private CompositeIndexBuilder mCompositeIndexBuilder = new CompositeIndexBuilder();
    private boolean mUnique = false;

    public CompositeIndexBuilder named(String name) {
        this.mCompositeIndexBuilder.named(name);
        if (this.mUnique) {
            this.mCompositeIndexBuilder.unique();
        }
        return this.mCompositeIndexBuilder;
    }

    public IndexBuilder unique() {
        this.mUnique = true;
        return this;
    }

    public Index build() {
        return new IndexImpl(this.mUnique, this.mCompositeIndexBuilder.mIndices, this.mCompositeIndexBuilder.mUniqueIndices);
    }

    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public class CompositeIndexBuilder {
        private CompositeIndexImpl mCurrentIndex;
        private List<CompositeIndex> mIndices;
        private List<CompositeIndex> mUniqueIndices;

        private CompositeIndexBuilder() {
            this.mIndices = new ArrayList(10);
            this.mUniqueIndices = new ArrayList(10);
        }

        public CompositeIndexBuilder named(String name) {
            this.mCurrentIndex = new CompositeIndexImpl(name);
            this.mIndices.add(this.mCurrentIndex);
            return this;
        }

        public CompositeIndexBuilder unique() {
            if (this.mIndices.remove(this.mCurrentIndex)) {
                this.mUniqueIndices.add(this.mCurrentIndex);
            }
            return this;
        }

        public CompositeIndexBuilder order(int order) {
            this.mCurrentIndex.setOrder(order);
            return this;
        }

        public CompositeIndexBuilder ascending() {
            this.mCurrentIndex.setAscending(true);
            return this;
        }

        public CompositeIndexBuilder descending() {
            this.mCurrentIndex.setAscending(false);
            return this;
        }

        public Index build() {
            return new IndexImpl(false, this.mIndices, this.mUniqueIndices);
        }
    }

    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    private class IndexImpl implements Index {
        private final CompositeIndex[] mNames;
        private final boolean mUnique;
        private final CompositeIndex[] mUniqueNames;

        public IndexImpl(boolean unique, List<CompositeIndex> names, List<CompositeIndex> uniqueNames) {
            this.mUnique = unique;
            this.mNames = (CompositeIndex[]) names.toArray(new CompositeIndex[names.size()]);
            this.mUniqueNames = (CompositeIndex[]) uniqueNames.toArray(new CompositeIndex[uniqueNames.size()]);
        }

        @Override // nl.qbusict.cupboard.annotation.Index
        public CompositeIndex[] indexNames() {
            return this.mNames;
        }

        @Override // nl.qbusict.cupboard.annotation.Index
        public boolean unique() {
            return this.mUnique;
        }

        @Override // nl.qbusict.cupboard.annotation.Index
        public CompositeIndex[] uniqueNames() {
            return this.mUniqueNames;
        }

        @Override // java.lang.annotation.Annotation
        public Class<? extends Annotation> annotationType() {
            return Index.class;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public class CompositeIndexImpl implements CompositeIndex {
        private boolean mAscending;
        private final String mName;
        private int mOrder;

        public CompositeIndexImpl(String name) {
            this.mName = name;
        }

        void setAscending(boolean ascending) {
            this.mAscending = ascending;
        }

        void setOrder(int order) {
            this.mOrder = order;
        }

        @Override // nl.qbusict.cupboard.annotation.CompositeIndex
        public boolean ascending() {
            return this.mAscending;
        }

        @Override // nl.qbusict.cupboard.annotation.CompositeIndex
        public int order() {
            return this.mOrder;
        }

        @Override // nl.qbusict.cupboard.annotation.CompositeIndex
        public String indexName() {
            return this.mName;
        }

        @Override // java.lang.annotation.Annotation
        public Class<? extends Annotation> annotationType() {
            return CompositeIndex.class;
        }
    }
}