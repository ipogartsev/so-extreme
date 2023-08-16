package model;

public class ExtremeActivity {

	private Long id;
	private String name;
	private String description;
	private String imageUrl = "";
	private double price = 20;
	private boolean simulator = true;
	private boolean disabledAccessible = true;

	public ExtremeActivity() {
    }

	public ExtremeActivity(Long id, String name, String description, String imageUrl, double price, boolean simulator, boolean disabledAccessible) {
        this.id = id;
		this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.price = price;
        this.simulator = simulator;
        this.disabledAccessible = disabledAccessible;
    }
	
	public ExtremeActivity(String name, String description) {
		
		this.name = name;
		this.description = description;
		
	
	}

	// Getters and Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isSimulator() {
		return simulator;
	}

	public void setSimulator(boolean simulator) {
		this.simulator = simulator;
	}

	
	public boolean isDisabledAccessible() {
		return disabledAccessible;
	}

	public void setDisabledAccessible(boolean disabledAccessible) {
		this.disabledAccessible = disabledAccessible;
	}

	@Override
	public String toString() {
		return "ExtremeActivity [id=" + id + ", name=" + name + ", description=" + description + ", imageUrl="
				+ imageUrl + ", price=" + price + ", simulator=" + simulator + ", disabledAccessible=" + disabledAccessible + "]";
	}
}
