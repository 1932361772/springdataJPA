package cn.itmuch.entity;

public class Phone3NoEntity {
	private Integer id;
	private String name;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public Phone3NoEntity(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Phone3 [id=" + id + ", name=" + name + "]";
	}

}
