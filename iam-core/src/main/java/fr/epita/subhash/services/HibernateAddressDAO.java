/**
 * 
 */
package fr.epita.subhash.services;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.epita.subhash.datamodel.Address;

/**
 * @author subhash
 *
 */
@Repository
public class HibernateAddressDAO implements Dao<Address> {

	/* (non-Javadoc)
	 * @see fr.epita.subhash.services.Dao#write(java.lang.Object)
	 */
	public void write(Address instance) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see fr.epita.subhash.services.Dao#delete(java.lang.Object)
	 */
	public void delete(Address instance) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see fr.epita.subhash.services.Dao#update(java.lang.Object)
	 */
	public void update(Address instance) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see fr.epita.subhash.services.Dao#search(java.lang.Object)
	 */
	public List<Address> search(Address instance) {
		// TODO Auto-generated method stub
		return null;
	}

}
