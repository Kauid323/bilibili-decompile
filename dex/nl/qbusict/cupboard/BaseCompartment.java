package nl.qbusict.cupboard;

import nl.qbusict.cupboard.convert.EntityConverter;

class BaseCompartment {
    protected final Cupboard mCupboard;

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseCompartment(Cupboard cupboard) {
        this.mCupboard = cupboard;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T> EntityConverter<T> getConverter(Class<T> clz) {
        return this.mCupboard.getEntityConverter(clz);
    }
}