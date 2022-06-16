/* NameRepository.java
 Name Repository class
 Author: Zaeem Petersen (219010145)
 Date: 14 June 2022
*/

package za.ac.cput.repository;
import za.ac.cput.domain.Name;

import java.util.HashSet;
import java.util.Optional;
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
    public Name save(Name name) {
        boolean success = NameDB.add(name);

        if(!success){
            return null;
        }
        else
            return name;
    }

    @Override
    public Optional<Name> read(Name.NameId nameId) {
        return this.repository.read(nameId);
    }


    @Override
    public void delete(Name name) {
    this.NameDB.remove(name);
    }

    @Override
    public Set<Name> getAll() {
        return NameDB;
    }
}
