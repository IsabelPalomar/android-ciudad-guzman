package android.example.com.feriaciudadguzman.models;


public class Event {

    private String name;
    private String description;
    private String address;
    private int imageId;

    public Event(String name, String description, String address, int imageId) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getAddress() {
        return address;
    }

    public int getImageId() {
        return imageId;
    }

}
