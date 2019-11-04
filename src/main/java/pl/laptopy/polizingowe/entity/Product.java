package pl.laptopy.polizingowe.entity;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long id;
    private String brand;
    private String model;
    private String processor;
    private String graphics;
    private String memory;
    private String screen;
    private String ram;
    private String network;
    private String color;
    private String weight;
    private String operatingSystem;
    private String usb;
    private String additionalInformation;
    private String price;
    private String productPicPath;

    public Product() {
    }

    public Product(String brand, String model, String processor, String graphics, String memory, String screen, String ram, String network, String color, String weight, String operatingSystem, String usb, String additionalInformation, String price, String productPicPath) {
        this.brand = brand;
        this.model = model;
        this.processor = processor;
        this.graphics = graphics;
        this.memory = memory;
        this.screen = screen;
        this.ram = ram;
        this.network = network;
        this.color = color;
        this.weight = weight;
        this.operatingSystem = operatingSystem;
        this.usb = usb;
        this.additionalInformation = additionalInformation;
        this.price = price;
        this.productPicPath = productPicPath;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getGraphics() {
        return graphics;
    }

    public void setGraphics(String graphics) {
        this.graphics = graphics;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getUsb() {
        return usb;
    }

    public void setUsb(String usb) {
        this.usb = usb;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getProductPicPath() {
        return productPicPath;
    }

    public void setProductPicPath(String productPicPath) {
        this.productPicPath = productPicPath;
    }
}
