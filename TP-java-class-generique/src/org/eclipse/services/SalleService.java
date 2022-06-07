package org.eclipse.services;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.classes.Salles;
import org.eclipse.interfaces.IDao;

public class SalleService implements IDao<Salles> {

	
	private List<Salles>salles ;
	
	
	
	public SalleService() {
		salles = new ArrayList<Salles>();
	}

	@Override
	public boolean create(Salles o) {
		// TODO Auto-generated method stub
		return salles.add(o);
	}

	@Override
	public boolean update(Salles o) {
		// TODO Auto-generated method stub
		for (Salles s:salles )
		{
			if (s.getId() == o.getId())
			{
				s.setCode(o.getCode());
				s.setLibelle(o.getLibelle());
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean delete(Salles o) {
		// TODO Auto-generated method stub
		return salles.remove(o);
	}

	@Override
	public Salles findById(int id) {
		// TODO Auto-generated method stub
		for (Salles s : salles)
		{
			if (s.getId() == id)
			{
				return s;
			}
		
		}
		return null;
	}

	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return salles;
	}

}
