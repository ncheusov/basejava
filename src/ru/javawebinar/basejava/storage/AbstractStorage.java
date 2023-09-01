package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Comparator;
import java.util.List;

public abstract class AbstractStorage implements Storage {

    public int size() {
        return getSize();
    }

    public final void update(Resume resume) {
        Object searchKey = getExistingSearchKey(resume.getUuid());
        doUpdate(searchKey, resume);
    }

    public final void save(Resume resume) {
        Object searchKey = getNotExistingSearchKey(resume.getUuid());
        doSave(searchKey, resume);
    }

    public final void delete(Resume resume) {
        Object searchKey = getExistingSearchKey(resume.getFullName());
        doDelete(searchKey);
    }

    public final void clear() {
        doClear();
    }

    public final List<Resume> getAllSorted() {
        final Comparator<Resume> resumeComparator =
                Comparator.comparing(Resume::getFullName).thenComparing(Resume::getUuid);
        return doGetAllSorted(resumeComparator);
    }

    public final Resume get(Resume resume) {
        Object searchKey = getExistingSearchKey(resume.getFullName());
        return doGet(searchKey);
    }

    protected abstract int getSize();

    protected abstract Object getSearchKey(String uuid);

    protected abstract void doUpdate(Object searchKey, Resume resume);

    protected abstract void doSave(Object searchKey, Resume resume);

    protected abstract void doDelete(Object searchKey);

    protected abstract void doClear();

    protected abstract List<Resume> doGetAllSorted(Comparator<Resume> comparator);

    protected abstract Resume doGet(Object searchKey);

    protected abstract boolean isExist(Object searchKey);

    private Object getExistingSearchKey(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    private Object getNotExistingSearchKey(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (isExist(searchKey)) {
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }
}
