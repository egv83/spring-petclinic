package org.springframework.samples.petclinic.domain.model;


public class PetType {
	private Integer id;
	private String name;

	public PetType(PetTypeBuilder bulder){
		this.id = bulder.id;
		this.name = bulder.name;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static PetTypeBuilder builder(){
		return new PetTypeBuilder();
	}

	public static class PetTypeBuilder{
		private Integer id;
		private String name;

		public PetTypeBuilder id(Integer id){
			this.id = id;
			return this;
		}

		public PetTypeBuilder name(String name){
			this.name = name;
			return this;
		}

		public PetType build(){
			return new PetType(this);
		}

	}

}
