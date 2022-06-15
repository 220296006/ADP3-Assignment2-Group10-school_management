package za.ac.cput.service;

public interface IServices <T,ID>{
    T create(T t);
    T read(ID id);
    T update(T t);
    boolean delete(ID id);
}
