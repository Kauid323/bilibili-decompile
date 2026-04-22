package nl.qbusict.cupboard.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import nl.qbusict.cupboard.annotation.CompositeIndex;
import nl.qbusict.cupboard.annotation.Index;

public class IndexStatement {
    public static final String INDEX_PREFIX = "_cb";
    public final boolean[] mAscendings;
    public final String[] mColumnNames;
    public final String mIndexName;
    public final boolean mIsUnique;

    public IndexStatement(boolean isUnique, String[] columnNames, boolean[] ascendings, String indexName) {
        this.mIsUnique = isUnique;
        this.mColumnNames = columnNames;
        this.mAscendings = ascendings;
        this.mIndexName = indexName;
    }

    public String getCreationSql(String table) {
        return getCreationSql(table, true);
    }

    public String getCreationSql(String table, boolean includeIfNotExists) {
        StringBuilder sb = new StringBuilder("create ");
        if (this.mIsUnique) {
            sb.append("unique ");
        }
        sb.append("index ");
        if (includeIfNotExists) {
            sb.append("if not exists ");
        }
        sb.append(INDEX_PREFIX).append(this.mIndexName).append(" on %s (");
        int size = this.mColumnNames.length;
        sb.append('\'').append(this.mColumnNames[0]).append("' ").append(this.mAscendings[0] ? "ASC" : "DESC");
        for (int i = 1; i < size; i++) {
            sb.append(", '").append(this.mColumnNames[i]).append("' ").append(this.mAscendings[i] ? "ASC" : "DESC");
        }
        sb.append(')');
        return String.format(sb.toString(), table, Boolean.valueOf(includeIfNotExists));
    }

    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static class Builder {
        public static final String GENERATED_INDEX_NAME = "%s_%s";
        Map<String, Set<IndexColumnMetadata>> indexes = new HashMap();
        Map<String, Set<IndexColumnMetadata>> uniqueIndexes = new HashMap();

        public void addIndexedColumn(String table, String name, Index index) {
            boolean added = false;
            if (index.indexNames().length != 0) {
                addCompositeIndexes(name, this.indexes, index.indexNames());
                added = true;
            }
            if (index.uniqueNames().length != 0) {
                addCompositeIndexes(name, this.uniqueIndexes, index.uniqueNames());
                added = true;
            }
            if (!added) {
                boolean unique = index.unique();
                addCompositeIndex(name, unique ? this.uniqueIndexes : this.indexes, true, 0, String.format(GENERATED_INDEX_NAME, table, name));
            }
        }

        private void addCompositeIndexes(String name, Map<String, Set<IndexColumnMetadata>> collectionToAdd, CompositeIndex[] composites) {
            for (CompositeIndex ci : composites) {
                addCompositeIndex(name, collectionToAdd, ci.ascending(), ci.order(), ci.indexName());
            }
        }

        private void addCompositeIndex(String columnName, Map<String, Set<IndexColumnMetadata>> collectionToAdd, boolean ascending, int order, String indexName) {
            Set<IndexColumnMetadata> set = collectionToAdd.get(indexName);
            if (set == null) {
                set = new HashSet();
                collectionToAdd.put(indexName, set);
            }
            IndexColumnMetadata indexColumnMetadata = new IndexColumnMetadata(columnName, ascending, order);
            if (!set.add(indexColumnMetadata)) {
                throw new IllegalArgumentException(String.format("Column '%s' has two indexes with the same name %s", columnName, indexName));
            }
        }

        public List<IndexStatement> build() {
            List<IndexStatement> indexStatements = new ArrayList<>();
            Set<String> indexNames = new HashSet<>();
            for (Map.Entry<String, Set<IndexColumnMetadata>> indexEntry : this.indexes.entrySet()) {
                String indexName = indexEntry.getKey();
                indexNames.add(indexName);
                addStatementToList(indexName, false, indexStatements, indexEntry.getValue());
            }
            for (Map.Entry<String, Set<IndexColumnMetadata>> indexEntry2 : this.uniqueIndexes.entrySet()) {
                String indexName2 = indexEntry2.getKey();
                if (!indexNames.add(indexName2)) {
                    throw new IllegalArgumentException(String.format("There are both unique and non-unique indexes with the same name : %s", indexName2));
                }
                addStatementToList(indexName2, true, indexStatements, indexEntry2.getValue());
            }
            return indexStatements;
        }

        public Map<String, IndexStatement> buildAsMap() {
            Map<String, IndexStatement> map = new HashMap<>();
            for (IndexStatement is : build()) {
                map.put(is.mIndexName, is);
            }
            return map;
        }

        public void addStatementToList(String indexName, boolean unique, List<IndexStatement> indexStatements, Set<IndexColumnMetadata> metadatas) {
            List<IndexColumnMetadata> columnMetadatas = new ArrayList<>(metadatas);
            Collections.sort(columnMetadatas);
            int size = columnMetadatas.size();
            String[] columnNames = new String[size];
            boolean[] ascendingColumns = new boolean[size];
            for (int i = 0; i < size; i++) {
                IndexColumnMetadata indexColumnMetadata = columnMetadatas.get(i);
                columnNames[i] = indexColumnMetadata.mColumnName;
                ascendingColumns[i] = indexColumnMetadata.mAscending;
            }
            indexStatements.add(new IndexStatement(unique, columnNames, ascendingColumns, indexName));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
        public class IndexColumnMetadata implements Comparable<IndexColumnMetadata> {
            boolean mAscending;
            String mColumnName;
            int mOrder;

            public IndexColumnMetadata(String columnName, boolean ascending, int order) {
                this.mColumnName = columnName;
                this.mAscending = ascending;
                this.mOrder = order;
            }

            public int hashCode() {
                int result = (1 * 31) + (this.mColumnName == null ? 0 : this.mColumnName.hashCode());
                return result;
            }

            @Override // java.lang.Comparable
            public int compareTo(IndexColumnMetadata another) {
                if (this.mOrder < another.mOrder) {
                    return -1;
                }
                if (this.mOrder > another.mOrder) {
                    return 1;
                }
                throw new IllegalArgumentException(String.format("Columns '%s' and '%s' cannot have the same composite index order %d", this.mColumnName, another.mColumnName, Integer.valueOf(this.mOrder)));
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                IndexColumnMetadata other = (IndexColumnMetadata) obj;
                if (this.mColumnName == null) {
                    if (other.mColumnName != null) {
                        return false;
                    }
                } else if (!this.mColumnName.equals(other.mColumnName)) {
                    return false;
                }
                return true;
            }
        }
    }
}