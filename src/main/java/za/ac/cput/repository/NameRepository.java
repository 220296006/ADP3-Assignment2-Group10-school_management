/* NameRepository.java
 Name Repository class
 Author: Zaeem Petersen (219010145)
 Date: 14 June 2022
*/

package za.ac.cput.repository;
import za.ac.cput.domain.Name;

import java.util.HashSet;
import java.util.Set;

public class NameRepository implements INameRepository{

    private static NameRepository repository= null;
    private Set<Name> NameDB = null;

    private NameRepository(){
        NameDB = new HashSet<Name>();
    }

    //singleton
    public static NameRepository getRepository(){
        if(repository == null){
            repository = new NameRepository();
        }
        return repository;
    }

    @Override
    public Name create(Name name) {
        boolean success = NameDB.add(name);

        if(!success){
            return null;
        }
        else
            return name;
    }

    @Override
    public Name read(String firstName) {
        for(Name e : NameDB){
            if (e.getFirstName() == firstName)
                return e;
        }
        return null;
    }

    @Override
    public Name update(Name name) {
        Name oldName = read(name.getFirstName());
        if(oldName != null){
            NameDB.remove(oldName);
            NameDB.add(oldName);
            return name;
        }
        else
        return null;
    }

    @Override
    public boolean delete(String firstName) {
        Name nameDelete = read(firstName);
        if (nameDelete == null){
            return false;
        }
        else
            NameDB.remove(nameDelete);
            return true;
    }

    @Override
    public Set<Name> getAll() {
        return NameDB;
    }
}
