package java_files;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="properties")
public class properties 
{
	
	@Id
	@Column(name="id")
	@NotNull(message="is required")
	@Size(min=1,message="is required")
	public String id;
	
	@Column(name="no_of_rooms")
	@NotNull(message="is required")
	@Size(min=1,message="is required")
	public String no_of_rooms;
	
	@Column(name="furnished_status")
	@NotNull(message="is required")
	@Size(min=1,message="is required")
	public String furnished_status;
	
	@Column(name="location")
	@NotNull(message="is required")
	@Size(min=1,message="is required")
	public String location;
	
	@Column(name="type_of_accomodity")
	@NotNull(message="is required")
	@Size(min=1,message="is required")
	public String type_of_accommodation;
	
	@Column(name="lister_name")
	@NotNull(message="is required")
	@Size(min=1,message="is required")
	public String lister_name;
	
	public properties()
	{
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNo_of_rooms() {
		return no_of_rooms;
	}

	public void setNo_of_rooms(String no_of_rooms) {
		this.no_of_rooms = no_of_rooms;
	}

	public String getFurnished_status() {
		return furnished_status;
	}

	public void setFurnished_status(String furnished_status) {
		this.furnished_status = furnished_status;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getType_of_accommodation() {
		return type_of_accommodation;
	}

	public void setType_of_accommodation(String type_of_accommodation) {
		this.type_of_accommodation = type_of_accommodation;
	}

	public String getLister_name() {
		return lister_name;
	}

	public void setLister_name(String lister_name) {
		this.lister_name = lister_name;
	}

	@Override
	public String toString() {
		return "properties [id=" + id + ", no_of_rooms=" + no_of_rooms + ", furnished_status=" + furnished_status
				+ ", location=" + location + ", type_of_accommodation=" + type_of_accommodation + ", lister_name="
				+ lister_name + "]";
	}
	
	
	
	
}