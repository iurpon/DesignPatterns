package ru.trandefil.hw5;

import ru.trandefil.hw5.orm.CommonOrm;
import ru.trandefil.hw5.orm.first.IFirstOrm;
import ru.trandefil.hw5.orm.second.ISecondOrm;

import java.util.Set;

public class OrmAdapter implements CommonOrm<IDbEntity> {

    private Object customOrm;

    public OrmAdapter(Object customOrm) {
        this.customOrm = customOrm;
    }

    @Override
    public void create(IDbEntity entity) {
        if (isFirstOrm()) {
            IFirstOrm<IDbEntity> iFirstOrm = (IFirstOrm) customOrm;
            iFirstOrm.create(entity);
        }
    }

    @Override
    public void delete(IDbEntity entity) {
        if (isFirstOrm()) {
            IFirstOrm<IDbEntity> iFirstOrm = (IFirstOrm) customOrm;
            iFirstOrm.delete(entity);
        }
    }

    @Override
    public Set<IDbEntity> getAll() {
        if (!isFirstOrm()) {
            return ((ISecondOrm) customOrm).getContext().getUsers();
        }
        return null;
    }

    @Override
    public Set<IDbEntity> getAllInfo() {
        if (!isFirstOrm()) {
            return ((ISecondOrm) customOrm).getContext().getUserInfo();
        }
        return null;
    }

    @Override
    public void update(IDbEntity entity) {
        if (isFirstOrm()) {
            IFirstOrm<IDbEntity> iFirstOrm = (IFirstOrm) customOrm;
            iFirstOrm.update(entity);
        }
    }

    @Override
    public IDbEntity read(Long id) {
        if (isFirstOrm()) {
            IFirstOrm<IDbEntity> iFirstOrm = (IFirstOrm) customOrm;
            return iFirstOrm.read(id.intValue());
        }
        return null;
    }

    private boolean isFirstOrm() {
        return customOrm instanceof IFirstOrm;
    }

}
