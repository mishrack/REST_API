package course.restapi.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity				// Entity makes it an entity to be used by JPA which will create a table with it's name and columns in insttance type
public class Topics {
	
	@Id				// Id makes the instance variable String is as primary key of table Topic
	private String id  ;
	private String name ;
	private String desc ;
	
	public Topics()
	{
		
	}
	public Topics(String id, String name, String desc) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	

}
