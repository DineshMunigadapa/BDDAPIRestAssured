package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.Location;
import pojo.addplace;

public class TestDataBuild {
	
	public addplace addPlacePayLoad(String name,String language,String address)
	{
		addplace a=new addplace();
		a.setAccuracy(50);
		a.setName(name);
		a.setLanguage(language);
		a.setPhone_number("(+91) 983 893 3937");
		a.setAddress(address);
		a.setWebsite("http://google.com");
		List<String> str=new ArrayList<String>();
		str.add("shoe park");
		str.add("shop");
		a.setTypes(str);
		Location loc=new Location();
		loc.setLat(-38.383494);
		loc.setLng(33.427362);
		a.setLocation(loc);
		return a;

	}

}
